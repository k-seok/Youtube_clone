package kiseok.youtube_clone.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;
import java.util.Date;

@Embeddable
@Getter
@NoArgsConstructor
public class VideoInfo {

    private String title;
    private String description;
    private Long _like = 0L;
    private Long dislike = 0L;
    private Long views = 0L;


    private LocalDateTime createTime;
    private String fileUrl;

    @Builder
    public VideoInfo(String title, String description, String fileUrl) {
        this.title = title;
        this.description = description;
        this.fileUrl = fileUrl;
    }

    public void updateInfo(String title, String description, String fileUrl) {
        if(title != null)
            this.title = title;
        if(description != null)
            this.description = description;
        if(fileUrl != null)
            this.fileUrl = fileUrl;
    }

}
