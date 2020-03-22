package Aamir.repository;

import Aamir.model.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/29 10:07
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    //List<Comment> findAllByDeleted(Boolean deleted);
    Page<Comment> findAllByDeleted(Boolean deleted,Pageable pageable);
    Page<Comment> findAllByAllowNotification(Boolean notification,Pageable pageable);
    Page<Comment> findAllByStatus(Integer status,Pageable pageable);
    List<Comment> findAllByPostId(Integer id);

    List<Comment> findAllByPostIdAndStatusAndDeletedAndParentId(Integer postid,Integer status,Boolean deleted,Integer parentid);

    Long countByAllowNotification(Boolean allow);
    List<Comment> findAllByAllowNotification(Boolean notification);
}
