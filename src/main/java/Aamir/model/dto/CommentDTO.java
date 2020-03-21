package Aamir.model.dto;

import Aamir.model.entity.Comment;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/21 11:33
 */
@Data
@ToString
public class CommentDTO {
    private Comment comment;
    private List<Comment> replycomments;

}
