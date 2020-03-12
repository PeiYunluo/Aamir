package Aamir.model.params;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/11 17:33
 */
@Data
@ToString
public class PostSaveParam {

    private Integer id;
    private String title;
    private Integer status;
    private String url;
    private String originalContent;
    private String summary;
    private Boolean disallowComment;
    private Boolean deleted;
    //tagsid 维护posttag表
    private List<Integer> tagsid;
    //categoriesid 维护postcategory表
    private List<Integer> categoriesid;


}
