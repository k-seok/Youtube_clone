package kiseok.youtube_clone.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Channel {
    @Id
    @GeneratedValue
    @Column(name = "channel_id")
    private Long id;
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Channel(String name, Member member) {
        this.name = name;
        this.member = member;
    }

    @OneToMany(mappedBy = "channel")
    private List<Video> videos = new ArrayList<>();

    protected Channel() {

    }

//    @OneToMany(mappedBy = "channel")
//    private List<Comment> comments;

}
