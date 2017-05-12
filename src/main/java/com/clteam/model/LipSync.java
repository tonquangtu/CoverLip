package com.clteam.model;

import java.util.List;

/**
 * Created by Dell on 30-Apr-17.
 */
public class LipSync {

    private Video video;

    private LipSyncTemplate lipSyncTemplate;

    public LipSync() {}

    public LipSync(Video video, LipSyncTemplate lipSyncTemplate) {
        this.video = video;
        this.lipSyncTemplate = lipSyncTemplate;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public LipSyncTemplate getLipSyncTemplate() {
        return lipSyncTemplate;
    }

    public void setLipSyncTemplate(LipSyncTemplate lipSyncTemplate) {
        this.lipSyncTemplate = lipSyncTemplate;
    }

    public boolean equals(LipSync otherLipSync) {

        if (video == null || otherLipSync == null || otherLipSync.getVideo() == null) {
            return false;
        }

        if (video.getId() == otherLipSync.getVideo().getId()) {
            return true;
        }
        return false;

    }

    public static boolean isExitsItem(LipSync checkItem, List<LipSync> list) {
        if (checkItem == null || list == null || list.size() <= 0) {
            return false;
        }
        boolean isExists = false;
        try {
            int checkItemId = checkItem.getVideo().getId();
            for (LipSync item : list) {

                if (item.getVideo().getId() == checkItemId) {
                    isExists = true;
                    break;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        //   System.out.println("IsExits: " + isExists);
        return isExists;
    }

    public VideoWrapper toVideoWrapper() {

        VideoWrapper videoWrapper = new VideoWrapper();
        videoWrapper.setVideo(this.video);
        if (lipSyncTemplate != null) {
            videoWrapper.setVideoName(lipSyncTemplate.getLipSyncTemplateName());
        }

        return videoWrapper;
    }
}
