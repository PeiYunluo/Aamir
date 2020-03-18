package Aamir.service.Impl;

import Aamir.model.entity.Tag;
import Aamir.repository.TagRepository;
import Aamir.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    @Override
    public Boolean deleteTagbyid(Integer id) {
        Tag tag= tagRepository.findById(id).get();
        if ( tag!=null){
            tag.setDeleted(!tag.getDeleted());
            tagRepository.saveAndFlush(tag);
            return true;
        }
       else
           return false;
    }

    @Override
    public Boolean saveTag(Tag tag) {
        if(tag.getName()!=null || tag.getName()!=""){
            tagRepository.saveAndFlush(tag);
            return true;
        }
      else
          return false;
    }

    @Override
    public Boolean updateTagname(Tag newtag) {
        Tag oldtag = tagRepository.findById(newtag.getId()).get();
        if (newtag.getName()!=null&&newtag.getName()!=""){
            oldtag.setName(newtag.getName());
            tagRepository.saveAndFlush(oldtag);
            return true;
        }
     else
         return false;
    }

    @Override
    public Tag getTagbyid(Integer id) {
        return tagRepository.findById(id).get();
    }
}
