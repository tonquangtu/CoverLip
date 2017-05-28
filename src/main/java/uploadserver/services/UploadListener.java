package uploadserver.services;

import com.clteam.model.Post;
import com.google.api.services.youtube.model.Video;

/**
 * Created by Dell on 22-May-17.
 */
public interface UploadListener {

    void startUpload();

    void uploadComplete(Post post);

    void uploadSuccess(Post post, Video returnedVideo);

    void uploadError(Post post, String message);

}
