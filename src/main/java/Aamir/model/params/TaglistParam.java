package Aamir.model.params;

import lombok.Data;
import lombok.ToString;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/10 22:02
 */
@Data
@ToString
public class TaglistParam {
    Integer page;   //当前页码

    Integer limit;  //每页显示

    String sort;
}
