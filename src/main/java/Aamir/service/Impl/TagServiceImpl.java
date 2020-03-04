package Aamir.service.Impl;

import Aamir.model.entity.Tag;
import Aamir.repository.TagRepository;
import Aamir.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/4 9:31
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> getAlltags() {
        return tagRepository.findAllByDeleted(false);
    }

    @Override
    public Page<Tag> getTags(Pageable pageable) {

        return tagRepository.findAll(pageable);
    }
}
