package Aamir.repository;

import Aamir.model.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/29 10:06
 */
@Repository
public interface TagRepository extends JpaRepository<Tag,Integer>, JpaSpecificationExecutor<Tag> {
    List<Tag> findAllByDeleted(Boolean tagdeleted);
    Page<Tag> findAll(Pageable pageable);
    Optional<Tag> findById(Integer id);
    Long countByDeleted(Boolean deleted);

}
