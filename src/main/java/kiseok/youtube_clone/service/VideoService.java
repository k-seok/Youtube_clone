package kiseok.youtube_clone.service;

import kiseok.youtube_clone.domain.DTO.VideoDto;
import kiseok.youtube_clone.domain.Video;
import kiseok.youtube_clone.domain.VideoInfo;
import kiseok.youtube_clone.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.cache.spi.entry.StructuredMapCacheEntry;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VideoService {
    private final VideoRepository videoRepository;

    public Long upload(VideoDto videoDto, Long channelId){
//        channelRepository.findOne(channelId)
        VideoInfo videoInfo = videoDto.toInfo();
        Video video = Video.builder()
                .videoInfo(videoInfo)
//                .channel(channel)
                .build();

        videoRepository.save(video);
        return video.getId();
    }

    public Long updateVideo(Long videoId, VideoDto videoDto){
        VideoInfo videoInfo = videoDto.toInfo();
        Video video = videoRepository.findOne(videoId);
        video.getVideoInfo().updateInfo(videoDto.getTitle(), videoDto.getDescription(), videoDto.getFileUrl());

        return video.getId();
    }
    public void deleteVideo(Long videoId) {
        Video video = videoRepository.findOne(videoId);
        if (video == null) {
            throw new IllegalStateException("No such video to delete. 잘못된 접근입니다.");
        }
        videoRepository.delete(video);
    }



}
