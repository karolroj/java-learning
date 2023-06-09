package learning.springboot.learning.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class VideoEntity {
    
    private @Id @GeneratedValue Long id;
    private String name;
    
    private String description;
    
    
    protected VideoEntity() {
        this(null, null);
    }
    
    public VideoEntity(String name, String description) {
        this.id = null;
        this.name = name;
        this.description = description;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
