package learning.springboot.learning.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import learning.springboot.learning.models.Video;

@Service
public class VideoService {
    private List<Video> videos = List.of(
        new Video("Need HELP with your SPRING BOOT 3 App?"),
        new Video("Don't do THIS to your own CODE!"),
        new Video("SECRETS to fix BROKEN CODE!"));

    public List<Video> getVideos() {
        return videos;
    }

    public Video addVideo(Video video) {
        List<Video> videos = new ArrayList<>(this.videos);
        videos.add(video);
        this.videos = List.copyOf(videos);
        return video;
    }
}
