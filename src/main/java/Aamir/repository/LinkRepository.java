package Aamir.repository;

import Aamir.model.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/29 10:07
 */
@Repository
public interface LinkRepository extends JpaRepository<Link,Integer> {
    Long countByDeleted(Boolean deleted);
}
