package com.clteam.services.commonservice.impl;

import com.clteam.dataobject.*;
import com.clteam.model.*;
import com.clteam.repositories.api.CoverRepository;
import com.clteam.repositories.api.LipSyncRepository;
import com.clteam.repositories.api.UserRepository;
import com.clteam.repositories.api.VideoRepository;
import com.clteam.services.commonservice.api.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Created by Dell on 28-Apr-17.
 */
@Service
public class VideoServiceImpl implements VideoService{

    @Autowired
    private VideoRepository videoRepo;

    @Autowired
    private CoverRepository coverRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    LipSyncRepository lipSyncRepo;


    public Cover getCoverInfo(int videoId) {

        VideoInfoEntity videoEntity = videoRepo.getVideoInfo(videoId);
        return getCoverInfo(videoEntity);
    }

    @Override
    public List<Cover> getHotCovers(int limit) {

        List<Cover> hotCovers = new ArrayList<>();
        List<HotCoverEntity> hotCoverEntities = coverRepo.getLimitHotCover(limit);
        if (hotCoverEntities != null && hotCoverEntities.size() > 0) {

            for(HotCoverEntity hotCoverEntity : hotCoverEntities) {

                Cover cover = getCoverInfo(hotCoverEntity.getVideoId());
                if (cover != null) {
                    hotCovers.add(cover);
                }
            }
        }
        return hotCovers;
    }

    @Override
    public List<Cover> getCoversByName(String name, int limit) {

        List<CoverInfoEntity> coverInfoEntities = coverRepo.getCoversInfoByName(name,limit);
        return getCovers(coverInfoEntities);
    }

    /**
     * Sorted cover outcome by number of view
     * @param accountId
     * @param limit
     * @return
     */
    @Override
    public List<Cover> getCoversByAccountId(int accountId, int limit) {

        List<Cover> covers = new ArrayList<>();
        if (accountId > 0) {

            List<VideoInfoEntity> videoEntities = videoRepo.getVideosByAccountId(accountId, limit);
            if (videoEntities != null && videoEntities.size() > 0) {

                for (VideoInfoEntity videoEntity : videoEntities) {

                    Cover cover = getCoverInfo(videoEntity);
                    if (cover != null) {
                        covers.add(cover);
                    }
                }
            }
        }

        return covers;
    }

    // Can phai viet lai de tim danh sach cac bai hat tong cung playlist co cung luot nghe cao nhat
    @Override
    public List<Playlist> findCoversSamePlaylist(int videoId, int limit) {

        List<Playlist> playlists = new ArrayList<>();
        // get list playlist id
        List<CoverOfPlaylistEntity> itemsInDiffPlaylist  = coverRepo.getPlaylistItemsByVideoId(videoId, limit);

        if (itemsInDiffPlaylist != null && itemsInDiffPlaylist.size() > 0) {

            for (CoverOfPlaylistEntity itemEntity : itemsInDiffPlaylist) {

                Playlist playlist = getPlaylist(itemEntity.getPlaylistId());
                if (playlist != null) {
                    playlists.add(playlist);
                }
            }
        }
        return playlists;
    }

    @Override
    public List<Cover> searchCoverByName(String name, int limit) {

        List<CoverInfoEntity> coverInfoEntities = coverRepo.searchCoverByName(name, limit);
        return getCovers(coverInfoEntities);
    }

    @Override
    public List<Video> findTopVideoOfAccount(int accountId, int limit) {

        List<VideoInfoEntity> videoEntities = videoRepo.findTopVideoOfAccount(accountId, limit);
        return getVideos(videoEntities);
    }

    @Override
    public List<Cover> findTopCoverOfAccount(int accountId, int limit) {

        List<CoverInfoEntity> coverEntities = coverRepo.findTopCoverOfAccount(accountId, limit);
        return getCovers(coverEntities);
    }

    @Override
    public CoverWrapper getCoverWrapper(Cover cover) {

        CoverWrapper coverWrapper = null;
        if (cover != null) {

            coverWrapper = new CoverWrapper();
            coverWrapper.setCover(cover);
            if (cover.getVideo() != null) {
                Video video = cover.getVideo();
                User user = getUser(video.getAccount());
                coverWrapper.setUser(user);
                coverWrapper.setPlaylistId(getListPlaylistId(video.getId()));

                boolean isHot = false;
                HotCoverEntity hotCoverEntity = coverRepo.findHotCover(video.getId());
                if (hotCoverEntity != null) {
                    isHot = true;
                }
                coverWrapper.setHot(isHot);
            }
        }
        return coverWrapper;
    }

    @Override
    public List<LipSync> getHotLipSyncs(int limit) {
        return null;
    }

    @Override
    public List<LipSync> searchLipSyncByName(String name, int limit) {

        List<LipSyncTemplateInfoEntity> lipSyncTemplates = lipSyncRepo.searchLipSyncByName(name, limit);
        List<LipSync> lipSyncs = new ArrayList<>();

        if (lipSyncTemplates != null) {
            for (LipSyncTemplateInfoEntity lipSyncTemplateEntity : lipSyncTemplates) {

                LipSyncTemplate template = new LipSyncTemplate();
                template.copyData(lipSyncTemplateEntity);

                List<LipSyncInfoEntity> lipSyncEntities =  (List<LipSyncInfoEntity>)lipSyncTemplateEntity.getLipSyncInfosById();
                if (lipSyncEntities != null) {
                    for (LipSyncInfoEntity lipSyncEntity : lipSyncEntities) {

                        VideoInfoEntity videoEntity = lipSyncEntity.getVideoInfoByVideoId();
                        if (videoEntity != null) {
                            Video video = new Video();
                            video.copyData(videoEntity);
                            LipSync lipSync = new LipSync(video, template);
                            lipSyncs.add(lipSync);
                        }
                    }
                }
            }
        }
        return lipSyncs;
    }


    public List<Integer> getListPlaylistId(int videoId) {

        List<CoverOfPlaylistEntity> itemsInDiffPlaylist  = coverRepo.getPlaylistItemsByVideoId(videoId, 100);
        List<Integer> playlistIds = new ArrayList<>();
        if (itemsInDiffPlaylist != null) {
            for (CoverOfPlaylistEntity coverPlaylistEntity : itemsInDiffPlaylist) {
                playlistIds.add(coverPlaylistEntity.getPlaylistId());
            }
        }
        return playlistIds;
    }

    public User getUser(Account account) {

        User user = null;
        if (account != null) {
            user = new User();
            user.setAccount(account);
            UserInfoEntity userEntity = userRepo.getUserInfoByAccountId(account.getId());
            if (userEntity != null) {
                user.copyData(userEntity);
            }
        }
        return user;
    }

    public List<Video> getVideos(List<VideoInfoEntity> videoEntities) {

        List<Video> videos = new ArrayList<>();
        if (videoEntities != null && videoEntities.size() > 0) {

            for (VideoInfoEntity videoEntity : videoEntities) {

                Video video = getVideo(videoEntity);
                if (video != null) {
                    videos.add(video);
                }
            }
        }

        return videos;
    }

    public List<Cover> getCovers(List<CoverInfoEntity> coverInfoEntities) {

        List<Cover> covers = new ArrayList<>();
        if (coverInfoEntities != null && coverInfoEntities.size() > 0) {

            for (CoverInfoEntity coverEntity : coverInfoEntities) {
                Cover cover = getCoverInfo(coverEntity);
                if (cover != null) {
                    covers.add(cover);
                }
            }
        }
        return covers;
    }

    public Playlist getPlaylist(int playlistId) {

        Playlist playlist = new Playlist();
        PlaylistInfoEntity playlistEntity = coverRepo.getPlaylist(playlistId);
        if (playlistEntity != null) {

            playlist.copyData(playlistEntity);
            List<CoverOfPlaylistEntity> playlistItemEntities = coverRepo.getPlaylistItemsByPlaylistId(playlistId);
            if (playlistItemEntities != null && playlistItemEntities.size() > 0) {

                for (CoverOfPlaylistEntity itemEntity : playlistItemEntities) {

                    PlaylistItem item = new PlaylistItem();
                    item.setPlaylistId(itemEntity.getPlaylistId());
                    item.setPriority(itemEntity.getPriority());
                    item.setTimeAdd(itemEntity.getTimeAdd());

                    Cover cover = getCoverInfo(itemEntity.getVideoId());
                    item.setItem(cover);
                    playlist.addItem(item);
                }
            }
        }

        return  playlist;

    }

    public Cover getCoverInfo(CoverInfoEntity coverEntity) {

        Cover cover  = null;
        if (coverEntity != null) {

            VideoInfoEntity videoEntity = videoRepo.getVideoInfo(coverEntity.getVideoId());
            if (videoEntity != null) {

                Video video = new Video();
                Account account = new Account();
                cover = new Cover();

                cover.setCoverName(coverEntity.getCoverName());
                cover.setMp3Link(coverEntity.getMp3Link());
                video.copyData(videoEntity);
                AccountEntity accountEntity = videoEntity.getAccountByAccountId();

                if (accountEntity != null) {
                    account.copyData(accountEntity);
                }
                video.setAccount(account);
                cover.setVideo(video);
            }
        }
        return cover;
    }

    public Cover getCoverInfo(VideoInfoEntity videoEntity) {

        Cover cover = null;
        if (videoEntity != null) {

            Collection<CoverInfoEntity> coverEntities = videoEntity.getCoverInfosById();
            if (coverEntities != null && coverEntities.size() >= 1) {
                CoverInfoEntity coverEntity = (CoverInfoEntity)coverEntities.toArray()[0];
                if (coverEntity != null) {

                    cover = new Cover();
                    Video video = new Video();
                    Account account = new Account();

                    cover.setCoverName(coverEntity.getCoverName());
                    cover.setMp3Link(coverEntity.getMp3Link());
                    video.copyData(videoEntity);
                    AccountEntity accountEntity = videoEntity.getAccountByAccountId();

                    if (accountEntity != null) {
                        account.copyData(accountEntity);
                    }
                    video.setAccount(account);
                    cover.setVideo(video);
                }
            }
        }
        return cover;
    }

    public Video getVideo(VideoInfoEntity videoEntity) {

        Video video = null;
        if (videoEntity != null) {

            video = new Video();
            video.copyData(videoEntity);

            AccountEntity accountEntity = videoEntity.getAccountByAccountId();
            if (accountEntity != null) {
                Account account = new Account();
                account.copyData(accountEntity);
                video.setAccount(account);
            }
        }
        return video;
    }

    public void createTestLipSyncData() {


        List<CoverInfoEntity> coverInfoEntities = coverRepo.getAllCovers();
        List<Cover> covers = getCovers(coverInfoEntities);

        for (int i = 0; i < 100; i++) {

            // insert video template and template
            Cover cover = covers.get(i);
            VideoInfoEntity templateVideo = new VideoInfoEntity();
            templateVideo.setAccountId(1);
            templateVideo.setVideoLink(cover.getVideo().getVideoLink());
            templateVideo.setVideoThumbnailLink(cover.getVideo().getVideoThumbnailLink());
            templateVideo.setDuration(cover.getVideo().getDuration());
            templateVideo.setCreateDate(new Timestamp(System.currentTimeMillis()));
            templateVideo.setNumView(0);
            templateVideo.setNumLike(0);
            templateVideo.setNumComment(0);
            templateVideo.setState((byte)1);
            templateVideo.setDescription(cover.getVideo().getDescription());
            templateVideo.setType(3);

            int templateVideoId = videoRepo.insertVideo(templateVideo);
            if (templateVideoId != -1) {

                templateVideoId = templateVideo.getId();
                LipSyncTemplateInfoEntity templateEntity = new LipSyncTemplateInfoEntity();
                templateEntity.setVideoId(templateVideoId);
                templateEntity.setNumLipSync(4);
                templateEntity.setLipSyncTemplateName(cover.getCoverName());
                int lipSyncTempId = lipSyncRepo.insertTemplate(templateEntity);

                /////////////////////////////////////////////////////////////////////
                // insert video and lip sync
               for (int j = 1; j <= 4; j++) {

                   Random random = new Random();
                   int rand = random.nextInt(covers.size() - 1);
                   Cover coverDataSample = covers.get(rand);
                   VideoInfoEntity lipSyncVideo = new VideoInfoEntity();
                   lipSyncVideo.setAccountId(coverDataSample.getVideo().getAccount().getId());
                   lipSyncVideo.setVideoLink(coverDataSample.getVideo().getVideoLink());
                   lipSyncVideo.setVideoThumbnailLink(coverDataSample.getVideo().getVideoThumbnailLink());
                   lipSyncVideo.setDuration(new Time(System.currentTimeMillis()));
                   lipSyncVideo.setCreateDate(new Timestamp(System.currentTimeMillis()));
                   lipSyncVideo.setNumView(coverDataSample.getVideo().getNumView());
                   lipSyncVideo.setNumLike(coverDataSample.getVideo().getNumLike());
                   lipSyncVideo.setNumComment(coverDataSample.getVideo().getNumComment());
                   lipSyncVideo.setState(coverDataSample.getVideo().getState());
                   lipSyncVideo.setDescription(coverDataSample.getVideo().getDescription());
                   lipSyncVideo.setType(2);

                   int lipSyncVideoId = videoRepo.insertVideo(lipSyncVideo);

                   LipSyncInfoEntity lipSyncInfoEntity = new LipSyncInfoEntity();
                   lipSyncInfoEntity.setLipSyncTemplateId(lipSyncTempId);
                   lipSyncInfoEntity.setVideoId(lipSyncVideoId);
                   lipSyncRepo.insertLipSync(lipSyncInfoEntity);

               }

            }
        }

    }

    @Override
    public LipSync getLipSync(int videoId) {

        LipSync lipSync =  null;
        LipSyncInfoEntity lipSyncEntity = lipSyncRepo.getLipSync(videoId);
        if (lipSyncEntity != null) {
            lipSync = new LipSync();
            LipSyncTemplateInfoEntity templateEntity =  lipSyncEntity.getLipSyncTemplateInfoByLipSyncTemplateId();
            if (templateEntity != null) {

                LipSyncTemplate template = new LipSyncTemplate();

                VideoInfoEntity templateVideoEntity = templateEntity.getVideoInfoByVideoId();
                if (templateVideoEntity != null) {
                    Video video = new Video();
                    video.copyData(templateVideoEntity);
                    template.setVideo(video);
                }
                template.copyData(templateEntity);
                lipSync.setLipSyncTemplate(template);
            }

            VideoInfoEntity videoEntity = lipSyncEntity.getVideoInfoByVideoId();
            if (videoEntity != null) {
                Video video = new Video();
                video.copyData(videoEntity);
                lipSync.setVideo(video);
            }
        }
        return lipSync;
    }


}
