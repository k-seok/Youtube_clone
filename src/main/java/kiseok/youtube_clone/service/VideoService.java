package kiseok.youtube_clone.service;

import kiseok.youtube_clone.form.VideoForm;
import kiseok.youtube_clone.domain.Video;
import kiseok.youtube_clone.domain.VideoInfo;
import kiseok.youtube_clone.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VideoService {
    private final VideoRepository videoRepository;
    public Long upload(Video video){
        videoRepository.save(video);
        return video.getId();
    }

    public Long updateVideo(Long videoId, VideoForm videoForm){
//        VideoInfo videoInfo = videoForm.toInfo();
        Video video = videoRepository.findOne(videoId);
//        video.setVideo(videoForm.getTitle(), videoForm.getDescription(), videoForm.getFileUrl());

        return video.getId();
    }
    public void deleteVideo(Long videoId) {
        Video video = videoRepository.findOne(videoId);
        if (video == null) {
            throw new IllegalStateException("No such video to delete. 잘못된 접근입니다.");
        }
        videoRepository.delete(video);
    }

    public Video findVideo(Long videoId) {
        return videoRepository.findOne(videoId);
    }
    public List<Video> findVideos() {
        return videoRepository.findAll();
    }
    public String saveFile(MultipartFile file){

        String path = System.getProperty("user.dir") + "\\videos\\" + file.getOriginalFilename();

        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }


}
