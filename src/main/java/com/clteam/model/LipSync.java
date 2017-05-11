package com.clteam.model;

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
}
