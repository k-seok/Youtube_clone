package kiseok.youtube_clone.service;

import kiseok.youtube_clone.form.VideoForm;
import kiseok.youtube_clone.domain.Video;
import kiseok.youtube_clone.repository.VideoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

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
        VideoForm videoForm = new VideoForm();
        videoForm.setVideoDto("fileUrl", "title", "description");
        Long channelId = 5353L;
        Video video = new Video();
        video.setVideo(videoForm.getTitle(), videoForm.getDescription(), videoForm.getFileUrl());
        //when
        Long uploaded = videoService.upload(video);

        //then
        Video found = videoRepository.findOne(uploaded);
        assertThat(videoForm.getTitle()).isEqualTo(found.getTitle());
    }

    @Test
    public void 수정() throws Exception{
        //given
        VideoForm videoForm = new VideoForm();
        videoForm.setVideoDto("fileUrl", "title", "description");        Long channelId = 5353L;
        Video video = new Video();
        video.setVideo(videoForm.getTitle(), videoForm.getDescription(), videoForm.getFileUrl());
        Long uploaded = videoService.upload(video);

        //when
        videoForm.setVideoDto("u_fileUrl", "u_title", "u_description");
        Long updated = videoService.updateVideo(uploaded, videoForm);

        //then
        String updatedTitle = videoRepository.findOne(updated).getTitle();
        assertThat(updatedTitle).isEqualTo(videoForm.getTitle());
    }

    @Test
    public void 삭제() throws Exception{
        //given
        VideoForm videoForm = new VideoForm();
        videoForm.setVideoDto("fileUrl", "title", "description");
        Long channelId = 5353L;
        Video video = new Video();
        video.setVideo(videoForm.getTitle(), videoForm.getDescription(), videoForm.getFileUrl());
        Long uploaded = videoService.upload(video);

        //when
        videoService.deleteVideo(uploaded);

        //then
        Video one = videoRepository.findOne(uploaded);
        assertThat(one).isNull();
    }
}