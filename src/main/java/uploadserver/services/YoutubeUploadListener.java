package uploadserver.services;

import com.clteam.model.Post;
import com.google.api.services.youtube.model.Video;
import org.springframework.stereotype.Component;

/**
 * Created by Dell on 22-May-17.
 */

@Component
public class YoutubeUploadListener implements UploadListener {

//    @Autowired
//    StorageService storageService;

    @Override
    public void startUpload() {

    }

    @Override
    public void uploadComplete(Post post) {

    }

    @Override
    public void uploadSuccess(Post post, Video returnedVideo) {


    }

    @Override
    public void uploadError(Post post, String message) {

    }
}
