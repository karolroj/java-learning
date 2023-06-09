package learning.springboot.learning.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import learning.springboot.learning.models.Video;
import learning.springboot.learning.models.VideoSearch;
import learning.springboot.learning.repositories.VideoRepository;

@Service
public class VideoService {

    VideoRepository repository;

    public VideoService(VideoRepository repository) {
        this.repository = repository;
    }

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

    public List<Video> search(VideoSearch search) {
        if (StringUtils.hasText(search.name()) && StringUtils.hasText(search.description())) {
            return repository.findByNameContainsOrDescriptionContainsAllIgnoreCase(search.name(),
                    search.description());
        }

        if (StringUtils.hasText(search.name())) {
            return repository.findByNameIgnoreCase(search.name());
        }

        if (StringUtils.hasText(search.description())) {
            return repository.findByDescriptionIgnoreCase(search.description());
        }

        return Collections.emptyList();
    }
}
