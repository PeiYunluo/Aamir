package Aamir.repository;

import Aamir.model.entity.Category;
import Aamir.model.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/29 10:08
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findAllByDeleted(Boolean categorydeleted);
    Page<Category> findAll(Pageable pageable);
    Optional<Category> findById(Integer id);
}
