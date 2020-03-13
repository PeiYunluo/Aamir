package Aamir.model.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/13 16:53
 */
@Data
@ToString
public class PostDTO {
    private Integer id;
    private String title;
    private Integer status;
    private String url;
    private String originalContent;
    private String summary;
    private Boolean disallowComment;
    private Boolean deleted;
    private Long visits;
    //tagsid 维护posttag表
    private List<Integer> tagsid;
    //categoriesid 维护postcategory表
    private List<Integer> categoriesid;
}
