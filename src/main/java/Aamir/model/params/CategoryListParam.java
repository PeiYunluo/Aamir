package Aamir.model.params;

import lombok.Data;
import lombok.ToString;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/13 11:52
 */
@Data
@ToString
public class CategoryListParam {
    Integer page;   //当前页码

    Integer limit;  //每页显示

    String sort;
}
