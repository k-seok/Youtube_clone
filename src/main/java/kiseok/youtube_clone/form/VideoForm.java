package kiseok.youtube_clone.form;

import kiseok.youtube_clone.domain.VideoInfo;
import lombok.Data;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Getter
public class VideoForm {

    private String title;
    private String description;
    private MultipartFile file;

//    public VideoInfo toInfo(){
//        return VideoInfo.builder()
//                .title(this.title)
//                .description(this.description)
//                .fileUrl(this.fileUrl)
//                .build();
//    }

}
