package Aamir.repository;

import Aamir.model.entity.Tag;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/29 10:06
 */
@Repository
public interface TagRepository extends JpaRepository<Tag,Integer> {
    List<Tag> findAllByDeleted(Boolean tagdeleted);
    Page<Tag> findAll(Pageable pageable);
}
