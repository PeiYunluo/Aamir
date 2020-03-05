package Aamir.service;

import Aamir.model.entity.Tag;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/4 9:30
 */
public interface TagService {

    List<Tag> getAlltags();
    Page<Tag> getTags(Pageable pageable);
    Boolean deleteTagbyid(Integer id);
    Boolean saveTag(Tag tag);
    Boolean updateTagname(Tag tag);
}
