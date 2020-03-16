package Aamir.service;

import Aamir.model.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/14 21:50
 */
public interface CommentService {
    //未删除
    List<Comment> getAllcoments(Boolean deleted);

    Page<Comment> getAllComents(Pageable pageable);

    Page<Comment> getComments(Boolean deleted,Pageable pageable);
    //根据状态
    Page<Comment> getCommentsbystatus(Integer status,Pageable pageable);
    //根据通知
    Page<Comment> getCommentsbynotification(Boolean notification,Pageable pageable);

    Boolean deleteCommentbyid(Integer commentid);

    Boolean modifynotification(Integer commentid);

    Boolean modifystatus(Integer commentid);

    Boolean addComment(Comment comment);

}
