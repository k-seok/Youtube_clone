package kiseok.youtube_clone.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
public class Video {
    @Id
    @GeneratedValue
    @Column(name = "video_id")
    private Long id;
    private String name;
    private Channel channel;

    @Embedded
    private VideoInfo videoInfo;
    private List<Comment> comments;
    private VideoStatus videoStatus;
    private VideoType videoType;
}
