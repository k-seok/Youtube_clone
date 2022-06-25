package kiseok.youtube_clone.controller;

import kiseok.youtube_clone.form.VideoForm;
import kiseok.youtube_clone.domain.Video;
import kiseok.youtube_clone.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class videoController {
    private final VideoService videoService;

    @GetMapping("videos")
    public String list(Model model){
        List<Video> videos = videoService.findVideos();
        model.addAttribute("videos", videos);

        return "video/videos";
    }


    @GetMapping("videos/new")
    public String createForm(Model model) {
        model.addAttribute("form", new VideoForm());
        return "video/createVideoForm";
    }

    @PostMapping("videos/new")
    public String create(VideoForm videoForm){
        String fileUrl = videoService.saveFile(videoForm.getFile());

        Video video = new Video();
        video.setVideo(videoForm.getTitle(), videoForm.getDescription(), fileUrl);
        videoService.upload(video);

        return "redirect:/videos";
    }
}
