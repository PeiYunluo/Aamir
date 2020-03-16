package Aamir.repository;

import Aamir.model.entity.AamirConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/29 10:08
 */
@Repository
public interface AamirConfigRepository extends JpaRepository<AamirConfig,Integer> {
    AamirConfig findByConfigfieldAndAndConfigname(String configfield,String configname);
}
