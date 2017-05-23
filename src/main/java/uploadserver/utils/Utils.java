package uploadserver.utils;

/**
 * Created by Dell on 22-May-17.
 */
public class Utils {

    public static String getYoutubeVideoLink(String youtubeVideoId) {

        String link = "https://www.youtube.com/embed/" + youtubeVideoId;
        return link;
    }

    public static String getYoutubeThumbnailLink(String youtubeVideoId) {

        String link = "http://img.youtube.com/vi/" + youtubeVideoId + "/0.jpg";
        return link;
    }

    public static boolean validateTitle(String title) {

        if (title != null && !title.trim().isEmpty() && title.length() < 254) {
            return true;
        }
        return false;
    }

    public static boolean validateString(String aString) {

        if (aString != null && !aString.trim().isEmpty() && aString.length() < 1000) {
            return true;
        }
        return false;
    }


}
