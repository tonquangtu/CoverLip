package uploadserver.services;

import com.clteam.dataobject.AccountEntity;
import com.clteam.model.Account;
import com.clteam.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uploadserver.repositories.UploadRepository;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Dell on 22-May-17.
 */
@Service
public class UploadService {

    @Autowired
    StorageService storageService;

    @Autowired
    YoutubeUpload youtubeUpload;

    @Autowired
    UploadRepository uploadRepo;

    public String uploadFileService(Post post, MultipartFile part) {

        String message = "anhtu";
        AccountEntity accountEntity = uploadRepo.getAccountEntity(post.getAccountId());
        if (checkUploadPermission(accountEntity)) {
            message = doUploadFile(post, part);

        } else {
            message = "Bạn không co quyền đăng video";
        }

        return message;
    }

    public String doUploadFile(Post post, MultipartFile part) {
        String message = "";
        if (!part.isEmpty()) {
            try {

                String fileName = getUniqueString(post.getTitle());
                byte [] dataUpload = part.getBytes();
                String pathFile = storageService.storeUploadFile(fileName, dataUpload);

                if (pathFile != null && !pathFile.isEmpty()) {
                    YoutubeUploadListener listener = new YoutubeUploadListener();
                    youtubeUpload.uploadVideoHandler(post, pathFile, listener);
                    message = "success";

                } else {
                    message = "Lỗi ghi file";
                }
            } catch (IOException e) {
                e.printStackTrace();
                message  = "Lỗi ghi file";
            }
        } else {
            message = "File không được rỗng";
        }
        return message;
    }

    public String uploadMultipleFileService (String[] names, MultipartFile[] files) {
        if (files.length != names.length)
            return "Mandatory information missing";

        String message = "";
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String name = names[i];
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                message = message + "You successfully uploaded file=" + name
                        + " ";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        }
        return message;
    }

    public String getUniqueString (String source) {

        int randNumber = new Random().nextInt(1000000);
        String uniqueString = source + "-" + randNumber + "-" + System.currentTimeMillis();
        return uniqueString;
    }

    public boolean checkUploadPermission(AccountEntity accountEntity) {

        if (accountEntity != null && accountEntity.getState() == Account.ACTIVE_STATE) {
            return true;
        }
        return false;
    }




}
