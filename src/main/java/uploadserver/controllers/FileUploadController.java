package uploadserver.controllers;

import com.clteam.model.Post;
import com.clteam.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import uploadserver.services.UploadService;
import uploadserver.utils.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Handles requests for the application file upload requests
 */
@Controller
public class FileUploadController {

    @Autowired
    UploadService uploadService;


    /**
     * Upload single file using Spring Controller
     */
    @RequestMapping(value = "personal/upload", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView uploadFileHandler(@RequestParam("accountId") String accountId,
                                   @RequestParam("title") String title,
                                   @RequestParam("description") String description,
                                   @RequestParam("file") MultipartFile file) {

        ModelAndView modelAndView = new ModelAndView();
        Map<String, String> map = new HashMap<>();
        String message;
        try {

            int accIdNumber = Integer.parseInt(accountId);
            if (Utils.validateTitle(title) && Utils.validateString(description)) {
                Post post = new Post();
                post.setTitle(title);
                post.setDescription(description);
                post.setType(Video.COVER_TYPE);
                post.setAccountId(accIdNumber);

                message = uploadService.uploadFileService(post, file);
            } else {
                message = "Title hoặc mô tả không hợp lệ";
            }
        } catch (Exception e) {
            message = "error";
        }

        map.put("message", message);
        map.put("type", "upload");
        modelAndView.addAllObjects(map);
        modelAndView.setViewName("commonpage/personal_page");
        return modelAndView;
    }

    /**
     * Upload multiple file using Spring Controller
     */
    @RequestMapping(value = "uploadMultipleFile", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView uploadMultipleFileHandler(@RequestParam("name") String[] names,
                                     @RequestParam("file") MultipartFile[] files) {

        ModelAndView modelAndView = new ModelAndView();
        String message = uploadService.uploadMultipleFileService(names, files);

        Map<String, String> map = new HashMap<>();
        map.put("message", message);
        modelAndView.addAllObjects(map);
        modelAndView.setViewName("test/test_upload");
        return modelAndView;

    }


}