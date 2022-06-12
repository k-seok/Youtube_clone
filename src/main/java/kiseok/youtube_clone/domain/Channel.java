package kiseok.youtube_clone.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Getter
public class Channel {
    @Id
    @GeneratedValue
    @Column(name = "channel_id")
    private Long id;
    private String name;
    private Member owner;
    private List<Video> videos;
    private List<Comment> comments;

}
