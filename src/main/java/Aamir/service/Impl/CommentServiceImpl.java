package Aamir.service.Impl;

import Aamir.model.entity.Comment;
import Aamir.repository.CommentRepository;
import Aamir.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/14 21:52
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Page<Comment> getAllComents(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    //根据属性deleted
    //根据属性status
    //根据Allow notifacation
    @Override
    public List<Comment> getAllcoments(Boolean deleted) {
        return commentRepository.findAll();
    }

    //根据deleted
    @Override
    public Page<Comment> getComments(Boolean deleted,Pageable pageable) {

        return commentRepository.findAllByDeleted(deleted,pageable);
    }

    //根据notificcation
    @Override
    public Page<Comment> getCommentsbystatus(Integer status, Pageable pageable) {
        return commentRepository.findAllByStatus(status,pageable);
    }

    @Override
    public Page<Comment> getCommentsbynotification(Boolean allowNotification, Pageable pageable) {
        return commentRepository.findAllByAllowNotification(allowNotification,pageable);
    }

    @Override
    public Boolean deleteCommentbyid(Integer commentid) {
        Comment comment = commentRepository.findById(commentid).get();
        if (comment != null){
            comment.setDeleted(!comment.getDeleted());
            commentRepository.saveAndFlush(comment);
            return true;
        } else
        return false;
    }

    //置为false
    @Override
    public Boolean modifynotification(Integer commentid) {
        Comment comment = commentRepository.findById(commentid).get();
        if (comment != null && comment.getAllowNotification() == true){
            comment.setAllowNotification(false);
            commentRepository.saveAndFlush(comment);
            return true;
        } else
            return false;
    }

    @Override
    public Boolean modifystatus(Integer commentid) {
        Comment comment = commentRepository.findById(commentid).get();
        if (comment != null){
            if (comment.getStatus()==0){
                comment.setStatus(1);
            } else comment.setStatus(0);
            commentRepository.saveAndFlush(comment);
            return true;
        } else
            return false;
    }

    @Override
    public Boolean addComment(Comment comment) {
        if ((comment.getAuthor() != null || comment.getAuthor() =="")
        && (comment.getEmail() !=null || comment.getEmail() =="")
        && (comment.getContent() !=null || comment.getContent() == "")
        && (comment.getPostId() !=null || comment.getPostId() ==0)){
            commentRepository.saveAndFlush(comment);
            return true;
        } else
        return false;

    }

    @Override
    public Long getNotificationscounts() {
        return commentRepository.countByAllowNotification(true);
    }


    @Override
    public List<Comment> getAllcommentsbynotification(Boolean notifica) {
        List<Comment> list= commentRepository.findAllByAllowNotification(notifica);
        return list;
    }

    @Override
    public Boolean swichNotification(Integer id) {
        commentRepository.saveAndFlush(commentRepository.findById(id).get());
        return true;
    }
}
