package com.clteam.utils;

import com.clteam.model.*;
import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.Date;
import java.util.List;

/**
 * Created by Dell on 05-May-17.
 */
public class SimilarityVideo {

    public static int FILTER_BY_NAME_CLASS = 1;

    public static int FILTER_BY_OWNER_CLASS = 2;

    public static int FILTER_BY_HOT_CLASS = 3;

    public static int FILTER_BY_PLAYLIST_CLASS = 4;
    /**
     * Calculate similarity of two cover. CurrCover is cover is playing.
     * Other Cover is cover needed compare similarity with curr cover
     */
    public static float calculateSimilarity(CoverWrapper currCoverWrapper, CoverWrapper otherCoverWrapper, int state) {

        Cover currCover = currCoverWrapper.getCover();
        Cover otherCover = otherCoverWrapper.getCover();

        if (currCover == null || otherCover == null || currCover.getVideo() == null || otherCover.getVideo() == null) {
            return 0.0f;
        }
        if (currCover.getVideo().getId() == otherCover.getVideo().getId()) {
            return 0.0f;
        }

        float fName = factorForName(state) * similarityStrings(currCover.getCoverName(), otherCover.getCoverName());
        float fOwner = 0.0f;
        if (currCover.getVideo().getAccount() != null && otherCover.getVideo().getAccount() != null) {
            fOwner = factorForOwner(state) * similarityOwner(currCover.getVideo().getAccount(), otherCover.getVideo().getAccount());
        }
        float fPlaylist = factorForPlaylist(state) * similarityPlaylist(currCoverWrapper.getPlaylistId(), otherCoverWrapper.getPlaylistId());
        float fHot = factorForHot(state) * isHot(otherCoverWrapper.isHot());
        float fPopularOwner = factorForPopularOwner(state) * popularOwner(otherCoverWrapper.getUser());

        float fDescription = factorForDescription(state) * similarityStrings(currCover.getVideo().getDescription(), otherCover.getVideo().getDescription());
        float fTime = factorForTime(state) * similarityTime(currCover.getVideo().getCreateDate(), otherCover.getVideo().getCreateDate());
        float fPopularVideo = factorForPopularVideo(state) * popularOfVideo(otherCover.getVideo());
        if (otherCoverWrapper.getCover().getVideo().getId() == 264) {
            System.out.println("Diem tung thanh phan: ----------------------------");
            System.out.println("Fname: " + fName);
            System.out.println("FOwner: " + fOwner);
            System.out.println("fPlaylist: " + fPlaylist);
            System.out.println("fHot: " + fHot);
            System.out.println("fPopularOwner: " + fPopularOwner);
            System.out.println("fDescription: " + fDescription);
            System.out.println("fTime: " + fTime);
            System.out.println("fPopularVideo: " + fPopularVideo);
        }
        float f = fName + fOwner + fPlaylist + fHot + fPopularOwner + fDescription + fTime + fPopularVideo;
        return f;
    }

    public static float similarityStrings(String s1, String s2) {

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        String longer = s1, shorter = s2;
        if (s1.length() < s2.length()) { // longer should always have greater length
            longer = s2; shorter = s1;
        }
        int longerLength = longer.length();
        if (longerLength == 0) {
            /* both strings are zero length */
            return 0.0f;
        }
        float similarity =  (longerLength - editDistance(longer, shorter)) / (float) longerLength;
        return similarity;
    }

    public static int editDistance(String s1, String s2) {
        return StringUtils.getLevenshteinDistance(s1, s2);
    }

    public static float similarityOwner(Account currAccount, Account otherAccount) {

        if (currAccount == null || otherAccount == null) {
            return 0.0f;
        }

        return currAccount.getId() == otherAccount.getId() ? 1.0f : 0.0f;
    }

    public static float similarityPlaylist(List<Integer> currPlaylistIds, List<Integer> otherPlaylistIds) {

        if (currPlaylistIds == null || otherPlaylistIds == null || currPlaylistIds.size() <= 0 || otherPlaylistIds.size() <= 0) {
            return 0.0f;
        }

        for (Integer playlistId : currPlaylistIds) {

            for (Integer otherPlaylistId : otherPlaylistIds) {
                if (playlistId.intValue() == otherPlaylistId.intValue()) {
                    return 1.0f;
                }
            }
        }

        return 0.0f;
    }

    public static float isHot(boolean isHot) {

        return isHot ? 1.0f : 0.0f;
    }

    public static float popularOwner(User user) {

        if (user == null) {
            return 0.0f;
        }

        float maxItem = 50.0f;
        float maxFollow = 1000.0f;
        float scoreForNumItem = 0.0f;
        long totalItem = user.getNumCover() + user.getNumLipsync() + user.getNumPlaylist();

        scoreForNumItem = totalItem / maxItem;
        if (scoreForNumItem > 0.5f) {
            scoreForNumItem = 0.5f;
        }

        float scoreForNumFollow = user.getNumHaveFollowed() / maxFollow;
        if (scoreForNumFollow > 0.5f) {
            scoreForNumFollow = 0.5f;
        }

        return scoreForNumFollow + scoreForNumItem;
    }

    public static float similarityTime(Timestamp t1, Timestamp t2) {

        float similarity = 0.0f;
        Date d1 = new Date(t1.getTime());
        Date d2 = new Date(t2.getTime());

        Duration duration = Duration.between(d1.toInstant(), d2.toInstant());

        long period = duration.toDays() / 30;
        if (period < 1) {
            similarity = 1.0f;

        } else if (period < 3) {
            similarity = 0.7f;

        } else if (period < 6) {
            similarity = 0.5f;

        } else if (period < 12) {
            similarity = 0.3f;

        } else if (period < 24) {
            similarity = 0.1f;

        } else {
            similarity = 0.0f;
        }
        return similarity;
    }

    public static float popularOfVideo(Video video) {

        float maxInteraction = 10000.0f;
        float popular = 0.0f;
        if (video == null) {
            return popular;
        }
        int totalInteraction = video.getNumView() + 2 * (video.getNumLike() + video.getNumComment());
        float score =  totalInteraction / maxInteraction;
        if (score > 1.0f) {
            score = 1.0f;
        }
        return score;
    }



    public static float factorForName(int state) {
        if (state == FILTER_BY_NAME_CLASS) {
            return 35.0f;
        } else if (state == FILTER_BY_OWNER_CLASS) {
            return 15.0f;
        }
        return 20.0f;
    }

    public static float factorForOwner(int state) {
        if (state == FILTER_BY_NAME_CLASS) {
            return 10.0f;
        } else if(state == FILTER_BY_OWNER_CLASS) {
            return 15.0f;
        }
        return 15.0f;
    }

    public static float factorForPlaylist(int state) {
        return 15.0f;
    }

    public static float factorForPopularVideo(int state) {

        if(state == FILTER_BY_OWNER_CLASS) {
            return 15.0f;
        }
        return 10.0f;
    }

    public static float factorForPopularOwner(int state) {
        return 10.0f;
    }

    public static float factorForDescription(int state) {
        return 10.0f;
    }

    public static float factorForTime(int state) {
        return 10.0f;
    }

    public static float factorForHot(int state) {
        return 10.0f;
    }

}
