package Aamir.repository;


import Aamir.model.entity.PostTag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/29 10:09
 */
@Repository
public interface PostTagRepository  extends JpaRepository<PostTag,Integer> {
}
