package kiseok.youtube_clone.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Video {
    @Id
    @GeneratedValue
    @Column(name = "video_id")
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @Embedded
    private VideoInfo videoInfo;

    @OneToMany(mappedBy = "video")
    private List<Comment> comments= new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private VideoStatus videoStatus;
    @Enumerated(EnumType.STRING)
    private VideoType videoType;
}
