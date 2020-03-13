package Aamir.service.Impl;

import Aamir.model.entity.Post;
import Aamir.model.entity.PostTag;
import Aamir.model.entity.Tag;
import Aamir.repository.PostTagRepository;
import Aamir.service.PostTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/11 21:55
 */
@Service
public class PostTagServiceImpl implements PostTagService {
    @Autowired
    private PostTagRepository postTagRepository;

    //TODO
    @Override
    public List<Tag> getAlltags(List<Integer> list) {
       // List<Tag> tags = postTagRepository.findAllById(list);
        return  null;
    }

    @Override
    public PostTag add(Integer postid, Integer tagid) {
        PostTag postTag =new PostTag();
        postTag.setPostId(postid);
        postTag.setTagId(tagid);
        return postTagRepository.saveAndFlush(postTag);

    }

    @Override
    public List<Integer> getTagsidbyid(Integer postid) {
        List<Integer> integerList = new ArrayList<>();
        List<PostTag> postTagList =postTagRepository.findAll();
        for (PostTag posttag:postTagList
             ) {
            if (posttag.getPostId()==postid&&posttag.getDeleted()!=true){
                integerList.add(posttag.getTagId());
            }
        }
        return integerList;
    }

    @Override
    public boolean isexist(Integer postid, Integer tagid) {
        if (postTagRepository.existsByPostIdAndTagId(postid,tagid))
        return true;
        else return false;
    }
}
