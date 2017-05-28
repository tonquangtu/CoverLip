package uploadserver.services;

import com.clteam.dataobject.*;
import com.clteam.model.Post;
import com.clteam.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uploadserver.repositories.UploadRepository;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by Dell on 22-May-17.
 */
@Service
public class StorageService {

    @Autowired
    UploadRepository uploadRepo;

    public String storeUploadFile (String fileName, byte[] data) {

        String pathFile = null;
        if (data != null) {

            try {
                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "upload");
                if (!dir.exists())
                    dir.mkdirs();

                File saveFile = new File(dir.getAbsolutePath()
                        + File.separator + fileName);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(saveFile));
                stream.write(data);
                stream.close();
                System.out.println("File Name: " + saveFile.getAbsolutePath());
                pathFile = saveFile.getAbsolutePath();

            } catch (Exception e) {
                e.printStackTrace();
                pathFile = null;
            }
        }
        return pathFile;
    }

    public boolean savePostToDb(Post post) {

        // Save VideoInfoEntity
        // Save CoverInfoEntity or LipSyncInfoEntity
        // Increase num_cover or num_lipsync
        System.out.println("Before save");
        boolean saveSuccess = false;
        UserInfoEntity userEntity = uploadRepo.getUserEntity(post.getAccountId());
        if (userEntity != null) {

            VideoInfoEntity videoEntity = createVideoEntity(post);
            int insertId = uploadRepo.insertVideo(videoEntity);
            if (insertId != -1) {
                System.out.println("Insert VideoId: " + insertId);
                if (post.getType() == Video.COVER_TYPE) {

                    CoverInfoEntity coverEntity = new CoverInfoEntity();
                    coverEntity.setVideoId(insertId);
                    coverEntity.setCoverName(post.getTitle());
                    coverEntity.setMp3Link(post.getVideoLink());
                    int coverId = uploadRepo.insertCover(coverEntity);

                    if (coverId != -1) {
                        System.out.println("Insert CoverId: " + coverId);
                        userEntity.setNumCover(userEntity.getNumCover() + 1);
                        uploadRepo.updateUser(userEntity);

                        saveSuccess = true;
                    }
                } else {

                    LipSyncInfoEntity lipSyncEntity = new LipSyncInfoEntity();
                    lipSyncEntity.setVideoId(insertId);
                    lipSyncEntity.setLipSyncTemplateId(post.getLipSyncTemplateId());
                    int lipSyncId = uploadRepo.insertLipSync(lipSyncEntity);

                    if (lipSyncId != -1) {
                        userEntity.setNumLipsync(userEntity.getNumLipsync() + 1);
                        uploadRepo.updateUser(userEntity);
                        saveSuccess = true;
                    }
                }
                insertTempNewCover(insertId);
            }
        }

        System.out.println("Save success: " + saveSuccess);
        return saveSuccess;
    }

    public void insertTempNewCover(int videoId) {
        TempNewCoverAdminEntity tempNewCoverEntity = new TempNewCoverAdminEntity();
        tempNewCoverEntity.setVideoId(videoId);
        uploadRepo.insertTempNewCover(tempNewCoverEntity);
    }

    public VideoInfoEntity createVideoEntity(Post post) {
        VideoInfoEntity videoEntity = new VideoInfoEntity();
        videoEntity.setAccountId(post.getAccountId());
        videoEntity.setVideoLink(post.getVideoLink());
        videoEntity.setVideoThumbnailLink(post.getVideoThumbnailLink());
        videoEntity.setDuration(new Time(0, 4, 40));
        videoEntity.setCreateDate(new Timestamp(System.currentTimeMillis()));
        videoEntity.setNumView(0);
        videoEntity.setNumLike(0);
        videoEntity.setNumComment(0);
        videoEntity.setState(Video.ACTIVE_STATE);
        videoEntity.setDescription(post.getDescription());
        videoEntity.setType(post.getType());
        videoEntity.setStorageId(post.getStorageId());

        return videoEntity;
    }





    public void deleteFile(String pathFile) {

        File file = new File(pathFile);
        if (file.exists()) {
            file.delete();
        }
    }

}
