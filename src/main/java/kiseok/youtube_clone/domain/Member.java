package kiseok.youtube_clone.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;

    public Member(String name) {
        this.name = name;
    }

    @OneToOne(mappedBy = "member")
    private Channel channel;
    @OneToMany(mappedBy = "member")
    private List<Comment> comments = new ArrayList<>();

    protected Member() {

    }
}
