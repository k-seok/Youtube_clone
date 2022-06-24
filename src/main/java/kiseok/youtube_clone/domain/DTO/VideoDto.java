package kiseok.youtube_clone.domain.DTO;

import kiseok.youtube_clone.domain.Video;
import kiseok.youtube_clone.domain.VideoInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class VideoDto {
    private String fileUrl;
    private String title;
    private String description;

    public VideoDto(String fileUrl, String title, String description) {
        this.fileUrl = fileUrl;
        this.title = title;
        this.description = description;
    }

    public VideoInfo toInfo(){
        return VideoInfo.builder()
                .title(this.title)
                .description(this.description)
                .fileUrl(this.fileUrl)
                .build();
    }

}
