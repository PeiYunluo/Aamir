package Aamir.model.params.miscParams;

import Aamir.model.params.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/16 14:04
 */
@Data
@ToString
@EqualsAndHashCode(callSuper=false)
public class CategoryPageParam extends PageParam {
    Integer id;
    String categoryname;
}
