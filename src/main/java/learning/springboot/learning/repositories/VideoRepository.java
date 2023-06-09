package learning.springboot.learning.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import learning.springboot.learning.entities.VideoEntity;
import learning.springboot.learning.models.Video;

public interface VideoRepository extends JpaRepository<VideoEntity, Long> {
    List<Video> findByNameContainsOrDescriptionContainsAllIgnoreCase(String name, String description);

    List<Video> findByDescriptionIgnoreCase(String description);

    List<Video> findByNameIgnoreCase(String name);
}
