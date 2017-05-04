package com.clteam.services.commonservice.impl;

import com.clteam.dataobject.*;
import com.clteam.model.*;
import com.clteam.repositories.api.CoverRepository;
import com.clteam.repositories.api.VideoRepository;
import com.clteam.services.commonservice.api.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Dell on 28-Apr-17.
 */
@Service
public class VideoServiceImpl implements VideoService{

    @Autowired
    private VideoRepository videoRepo;

    @Autowired
    private CoverRepository coverRepo;

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

    @Override
    public List<Playlist> findCoversSamePlaylist(int videoId, int limit) {

        List<Playlist> playlists = new ArrayList<>();
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
    public List<Cover> findTopCoverOfAccount(int accountId, int limit) {




        return null;
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


}
