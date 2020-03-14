package Aamir.repository;

import Aamir.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/29 10:07
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
