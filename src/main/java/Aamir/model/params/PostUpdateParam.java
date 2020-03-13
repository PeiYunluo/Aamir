package Aamir.model.params;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/13 21:04
 */
@Data
@ToString
public class PostUpdateParam {
    private Integer id;
    private String title;
    private Integer status;
    private String url;
    private String summary;
    private String thumbnailurl;
    //tagsid 维护posttag表
    private List<Integer> tagsid;
    //categoriesid 维护postcategory表
    private List<Integer> categoriesid;

}
