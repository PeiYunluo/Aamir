package Aamir.repository;

import Aamir.model.entity.AamirConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/29 10:08
 */
@Repository
public interface AamirConfigRepository extends JpaRepository<AamirConfig,Integer> {
}
