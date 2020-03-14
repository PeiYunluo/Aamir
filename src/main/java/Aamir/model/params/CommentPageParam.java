package Aamir.model.params;

import lombok.Data;
import lombok.ToString;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/14 22:14
 */
@Data
@ToString
public class CommentPageParam {
    Integer page;   //当前页码

    Integer limit;  //每页显示

    String sort;

    Integer id;
}