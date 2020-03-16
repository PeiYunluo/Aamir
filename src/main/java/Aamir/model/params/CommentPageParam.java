package Aamir.model.params;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/14 22:14
 */
@Data
@ToString

//TODO:why
@EqualsAndHashCode(callSuper=false)
public class CommentPageParam extends PageParam {
    Boolean deleted;
    Integer status;
    Boolean allowNotification;
}