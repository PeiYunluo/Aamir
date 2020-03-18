package Aamir.repository;


import Aamir.model.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/29 10:07
 */
@Repository
public interface PostRepository  extends JpaRepository<Post,Integer> {
    List<Post> findAllById(Iterator<Integer> iterator);
    Long countByDeleted(Boolean delete);
    Long countByStatus(Integer status);
}
