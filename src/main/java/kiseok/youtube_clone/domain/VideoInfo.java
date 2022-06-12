package kiseok.youtube_clone.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class VideoInfo {
    private String description;
    private String like;
    private String dislike;
    private String views;
    private String createTime;

    public VideoInfo(String description, String like, String dislike, String views, String createTime) {
        this.description = description;
        this.like = like;
        this.dislike = dislike;
        this.views = views;
        this.createTime = createTime;
    }

    private VideoInfo() {

    }
}
