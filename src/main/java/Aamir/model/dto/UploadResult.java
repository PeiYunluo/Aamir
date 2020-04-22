package Aamir.model.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.http.MediaType;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/4/19 9:14
 */
@Data
@ToString
public class UploadResult {

    private String filename;

    private String filePath;

    private String key;

    private String thumbPath;

    private String suffix;

    private MediaType mediaType;

    private Long size;

    private Integer width;

    private Integer height;

}
