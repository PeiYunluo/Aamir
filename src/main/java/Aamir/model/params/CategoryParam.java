package Aamir.model.params;

import lombok.Data;
import lombok.ToString;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/5 10:12
 */
@Data
@ToString
public class CategoryParam {
    private Integer id;
    private String categroyname;
    private Boolean deleted;
    private Integer categroyrank;
    private String icon;
}
