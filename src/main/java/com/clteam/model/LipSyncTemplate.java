package com.clteam.model;

import com.clteam.dataobject.LipSyncTemplateInfoEntity;

/**
 * Created by Dell on 30-Apr-17.
 */
public class LipSyncTemplate {

    private int id;

    private Video video;

    private String lipSyncTemplateName;

    private int numLipSync;

    public LipSyncTemplate() {}

    public LipSyncTemplate(Video video, String lipSyncTemplateName, int numLipSync) {
        this.video = video;
        this.lipSyncTemplateName = lipSyncTemplateName;
        this.numLipSync = numLipSync;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public String getLipSyncTemplateName() {
        return lipSyncTemplateName;
    }

    public void setLipSyncTemplateName(String lipSyncTemplateName) {
        this.lipSyncTemplateName = lipSyncTemplateName;
    }

    public int getNumLipSync() {
        return numLipSync;
    }

    public void setNumLipSync(int numLipSync) {
        this.numLipSync = numLipSync;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void copyData(LipSyncTemplateInfoEntity templateEntity) {

        this.id = templateEntity.getId();
        this.lipSyncTemplateName = templateEntity.getLipSyncTemplateName();
        this.numLipSync = templateEntity.getNumLipSync();


    }
}
