package kiseok.youtube_clone.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Video {
    @Id
    @GeneratedValue
    @Column(name = "video_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @Embedded
    private VideoInfo videoInfo;

    @Builder
    public Video(Long id, Channel channel, VideoInfo videoInfo) {
        this.id = id;
        this.channel = channel;
        this.videoInfo = videoInfo;
    }

    @OneToMany(mappedBy = "video")
    private List<Comment> comments = new ArrayList<>();

//    @Enumerated(EnumType.STRING)
//    private VideoStatus videoStatus;
//    @Enumerated(EnumType.STRING)
//    private VideoType videoType;


}
