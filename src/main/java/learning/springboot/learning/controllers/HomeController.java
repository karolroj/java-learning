package learning.springboot.learning.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import learning.springboot.learning.models.Video;
import learning.springboot.learning.services.VideoService;

@Controller
public class HomeController {

    private final VideoService videoService;

    public HomeController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("videos", videoService.getVideos());
        return "index";
    }

    @PostMapping("/add-video")
    public String addVideo(@ModelAttribute Video video) {
        videoService.addVideo(video);
        return "redirect:/";
    }
}
