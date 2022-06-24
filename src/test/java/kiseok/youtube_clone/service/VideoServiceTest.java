package kiseok.youtube_clone.service;

import kiseok.youtube_clone.domain.DTO.VideoDto;
import kiseok.youtube_clone.domain.Video;
import kiseok.youtube_clone.repository.VideoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class VideoServiceTest {
    @Autowired
    VideoService videoService;
    @Autowired
    VideoRepository videoRepository;
    @Test
    public void 업로드() throws Exception{
        //given
        VideoDto videoDto = new VideoDto("fileUrl", "title", "description");
        Long channelId = 5353L;

        //when
        Long uploaded = videoService.upload(videoDto, channelId);

        //then
        Video found = videoRepository.findOne(uploaded);
        assertThat(videoDto.getTitle()).isEqualTo(found.getVideoInfo().getTitle());
    }

    @Test
    public void 수정() throws Exception{
        //given
        VideoDto videoDto = new VideoDto("fileUrl", "title", "description");
        Long channelId = 5353L;
        Long uploaded = videoService.upload(videoDto, channelId);

        //when
        VideoDto updatedDto = new VideoDto("u_fileUrl", "u_title", "u_description");
        Long updated = videoService.updateVideo(uploaded, updatedDto);

        //then
        String updatedTitle = videoRepository.findOne(updated).getVideoInfo().getTitle();
        assertThat(updatedTitle).isEqualTo(updatedDto.getTitle());
    }

    @Test
    public void 삭제() throws Exception{
        //given
        VideoDto videoDto = new VideoDto("fileUrl", "title", "description");
        Long channelId = 5353L;
        Long uploaded = videoService.upload(videoDto, channelId);

        //when
        videoService.deleteVideo(uploaded);

        //then
        Video one = videoRepository.findOne(uploaded);
        assertThat(one).isNull();
    }
}