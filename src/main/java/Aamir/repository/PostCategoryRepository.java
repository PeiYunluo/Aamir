package Aamir.repository;

import Aamir.model.entity.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/29 10:10
 */
@Repository
public interface PostCategoryRepository  extends JpaRepository<PostCategory,Integer> {
    boolean existsByPostIdAndCategoryId(Integer postid,Integer categoryid);
    List<PostCategory> findAllByCategoryId(Integer categoryid);
}
