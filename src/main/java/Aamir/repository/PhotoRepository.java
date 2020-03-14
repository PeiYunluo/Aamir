package Aamir.repository;

import Aamir.model.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/14 15:56
 */
@Repository
public interface PhotoRepository extends JpaRepository<Photo,Integer> {

}
