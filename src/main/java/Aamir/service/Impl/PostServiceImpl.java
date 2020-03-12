package Aamir.service.Impl;

import Aamir.model.entity.Post;
import Aamir.model.entity.PostTag;
import Aamir.model.params.PostSaveParam;
import Aamir.repository.PostRepository;
import Aamir.service.PostService;
import Aamir.service.PostTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/11 16:08
 */
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;



    @Override
    public Post saveandupdatePost(PostSaveParam postSaveParam) {
        Post post = new Post();
        post.setDisallowComment(postSaveParam.getDisallowComment());
        post.setOriginalContent(postSaveParam.getOriginalContent());
        post.setStatus(postSaveParam.getStatus());
        post.setUrl(postSaveParam.getUrl());
        post.setDeleted(postSaveParam.getDeleted());
        post.setTitle(postSaveParam.getTitle());
        post.setSummary(postSaveParam.getSummary());
        //新建并保存
        if (postSaveParam.getId() == null || postSaveParam.getId() == 0){

            return postRepository.saveAndFlush(post);
        } else if (postRepository.existsById(postSaveParam.getId())) //查找并保存
            {
                Post oldpost = postRepository.findById(postSaveParam.getId()).get();
                oldpost.setDisallowComment(postSaveParam.getDisallowComment());
                oldpost.setOriginalContent(postSaveParam.getOriginalContent());
                oldpost.setStatus(postSaveParam.getStatus());
                oldpost.setUrl(postSaveParam.getUrl());
                oldpost.setDeleted(postSaveParam.getDeleted());
                oldpost.setTitle(postSaveParam.getTitle());
                oldpost.setSummary(postSaveParam.getSummary());
                postRepository.saveAndFlush(oldpost);
                return postRepository.saveAndFlush(post);
        }
        return null;
    }
}
