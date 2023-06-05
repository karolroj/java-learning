package learning.springboot.learning.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import learning.springboot.learning.models.Video;
import learning.springboot.learning.services.VideoService;

@RestController
public class ApiController {
    
    private final VideoService videoService;

    public ApiController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/api/videos")
    public List<Video> getVideos() {
        return videoService.getVideos();
    }

    @PostMapping("/api/video")
    public Video addVideo(@RequestBody Video video) {
        return videoService.addVideo(video);
    }
}
