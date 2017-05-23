package uploadserver.services;

import com.clteam.model.Post;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.googleapis.media.MediaHttpUploaderProgressListener;
import com.google.api.client.http.InputStreamContent;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoSnippet;
import com.google.api.services.youtube.model.VideoStatus;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uploadserver.auth.Auth;
import uploadserver.utils.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class YoutubeUpload  {

    @Autowired
    StorageService storageService;

    private static YouTube youtube;

    private static final String VIDEO_FILE_FORMAT = "video/*";


    public void uploadVideoHandler(Post post, String pathFile, UploadListener listener) {

        Thread uploadThread = new Thread(new Runnable() {
            @Override
            public void run() {

                uploadFile(post, pathFile, listener);
            }
        });
        uploadThread.start();
    }


    public  void uploadFile(Post post, String pathFile, UploadListener listener) {

        if (listener != null) {
            listener.startUpload();
        }

        List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube.upload");

        try {
            Credential credential = Auth.authorize(scopes, "uploadvideo");

            youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, credential).setApplicationName(
                    "youtube-cmdline-uploadvideo-sample").build();

            // Add extra information to the video before uploading.
            Video videoObjectDefiningMetadata = new Video();
            VideoStatus status = new VideoStatus();
            status.setPrivacyStatus("public"); // or private
            videoObjectDefiningMetadata.setStatus(status);

            // Most of the video's metadata is set on the VideoSnippet object.
            VideoSnippet snippet = new VideoSnippet();
            snippet.setTitle(post.getTitle());
            snippet.setDescription(post.getDescription());

            // Set the keyword tags that you want to associate with the video.
            List<String> tags = new ArrayList<String>();
            tags.add(post.getTitle());
            tags.add("cover");
            tags.add("lip-sync");
            tags.add("CoverLip");
            snippet.setTags(tags);

            // Add the completed snippet object to the video resource.
            videoObjectDefiningMetadata.setSnippet(snippet);

            File file = new File(pathFile);
            InputStream is = new FileInputStream(file);

            InputStreamContent mediaContent = new InputStreamContent(VIDEO_FILE_FORMAT, is);

            System.out.println("Length: " + mediaContent.getLength());


            // Insert the video. The command sends three arguments. The first
            // specifies which information the API request is setting and which
            // information the API response should return. The second argument
            // is the video resource that contains metadata about the new video.
            // The third argument is the actual video content.
            YouTube.Videos.Insert videoInsert = youtube.videos()
                    .insert("snippet,statistics,status", videoObjectDefiningMetadata, mediaContent);

            // Set the upload type and add an event listener.
            MediaHttpUploader uploader = videoInsert.getMediaHttpUploader();

            // Indicate whether direct media upload is enabled. A value of
            // "True" indicates that direct media upload is enabled and that
            // the entire media content will be uploaded in a single request.
            // A value of "False," which is the default, indicates that the
            // request will use the resumable media upload protocol, which
            // supports the ability to resume an upload operation after a
            // network interruption or other transmission failure, saving
            // time and bandwidth in the event of network failures.
            uploader.setDirectUploadEnabled(false);

            MediaHttpUploaderProgressListener progressListener = new MediaHttpUploaderProgressListener() {

                public void progressChanged(MediaHttpUploader uploader) throws IOException {
                    switch (uploader.getUploadState()) {
                        case INITIATION_STARTED:
                            System.out.println("Initiation Started");
                            break;
                        case INITIATION_COMPLETE:
                            System.out.println("Initiation Completed");
                            break;
                        case MEDIA_IN_PROGRESS:
                            System.out.println("Upload in progress");
//                            System.out.println("Upload percentage: " + uploader.getProgress());
                            break;
                        case MEDIA_COMPLETE:
                            System.out.println("Upload Completed!");
                            break;
                        case NOT_STARTED:
                            System.out.println("Upload Not Started!");
                            break;
                    }
                }
            };

            uploader.setProgressListener(progressListener);

            // Call the API and upload the video.
            Video returnedVideo = videoInsert.execute();

            if (listener != null) {
                listener.uploadComplete(post);

            }

            if (returnedVideo != null && returnedVideo.getId() != null) {
                savePostToDb(post, returnedVideo);

                if (listener != null) {
                    listener.uploadSuccess(post, returnedVideo);
                }
            }

            printUploadState(returnedVideo);

        } catch (Exception e) {

            if (listener != null) {
                listener.uploadError(post, e.getMessage());
            }
            e.printStackTrace();
        }

        storageService.deleteFile(pathFile);
    }

    public static void print(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder out = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(out.toString());   //Prints the string content read from input stream
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("data: " + out.toString());
    }

    public static void main(String[] args) {

        String pathFile = "E:\\Tomcat server\\apache-tomcat-9.0.0.M18\\apache-tomcat-9.0.0.M18\\upload\\Anh khong-588200-1495511596129";
        Post post = new Post();
        post.setTitle("aaaa");
        post.setDescription("ssss");

        new YoutubeUpload().uploadFile(post, pathFile, null);
    }

    public void printUploadState(Video returnedVideo) {

        // Print data about the newly inserted video from the API response.
        System.out.println("\n================== Returned Video ==================\n");
        System.out.println("  - Id: " + returnedVideo.getId());
        System.out.println("  - Title: " + returnedVideo.getSnippet().getTitle());
        System.out.println("  - Tags: " + returnedVideo.getSnippet().getTags());
        System.out.println("  - Privacy Status: " + returnedVideo.getStatus().getPrivacyStatus());
        System.out.println("  - Video Count: " + returnedVideo.getStatistics().getViewCount());
    }

    public void savePostToDb(Post post, Video returnedVideo) {

        System.out.println("Upload success");
        String videoLink = Utils.getYoutubeVideoLink(returnedVideo.getId());
        String thumbnailLink = Utils.getYoutubeThumbnailLink(returnedVideo.getId());
        post.setStorageId(returnedVideo.getId());
        post.setVideoLink(videoLink);
        post.setVideoThumbnailLink(thumbnailLink);

        storageService.savePostToDb(post);
    }


}
