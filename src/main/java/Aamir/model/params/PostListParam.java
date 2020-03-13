package Aamir.model.params;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/13 16:30
 */
@Data
@ToString
public class PostListParam {

    Integer page;   //当前页码

    Integer limit;  //每页显示

    String sort;

}
