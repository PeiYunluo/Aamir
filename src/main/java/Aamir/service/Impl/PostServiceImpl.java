package Aamir.service.Impl;

import Aamir.model.dto.PostDTO;
import Aamir.model.entity.Post;
import Aamir.model.entity.PostTag;
import Aamir.model.entity.Tag;
import Aamir.model.params.PostSaveParam;
import Aamir.model.params.PostUpdateParam;
import Aamir.repository.CategoryRepository;
import Aamir.repository.PostRepository;
import Aamir.repository.TagRepository;
import Aamir.service.PostService;
import Aamir.service.PostTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/11 16:08
 */
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private CategoryRepository categoryRepository;



    @Override
    public Post saveandupdatePost(PostSaveParam postSaveParam) {

        //新建并保存
        if (postSaveParam.getId() == null || postSaveParam.getId() == 0){
            Post post = new Post();
            post.setDisallowComment(postSaveParam.getDisallowComment());
            post.setOriginalContent(postSaveParam.getOriginalContent());
            post.setStatus(postSaveParam.getStatus());
            post.setUrl(postSaveParam.getUrl());
            post.setDeleted(postSaveParam.getDeleted());
            post.setTitle(postSaveParam.getTitle());
            post.setSummary(postSaveParam.getSummary());
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
                return postRepository.saveAndFlush(oldpost);
        }
        return null;
    }

    @Override
    public Page<Post> getPosts(Pageable pageable) {
        Page<Post> postPage = postRepository.findAll(pageable);
        return postPage;
    }


    //TODO:未完成
    @Override
    public Page<PostDTO> getPostDTOs(Pageable pageable) {
        List<Post> postList = postRepository.findAll();
        List<Tag> tagList = tagRepository.findAllByDeleted(false);
        return null;
    }

    @Override
    public boolean deletePostbyid(Integer postid) {
        Post post = postRepository.findById(postid).get();
        if(post!=null){
            post.setDeleted(!post.getDeleted());
            postRepository.saveAndFlush(post);
            return true;
        }else return false;
    }

    @Override
    public boolean switchComment(Integer postid) {
        Post post = postRepository.findById(postid).get();
        if(post!=null){
            post.setDisallowComment(!post.getDisallowComment());
            postRepository.saveAndFlush(post);
            return true;
        }else return false;
    }

    @Override
    public Post updatePost(PostUpdateParam postUpdateParam) {
        Post post = postRepository.findById(postUpdateParam.getId()).get();
        post.setThumbnailurl(postUpdateParam.getThumbnailurl());
        post.setSummary(postUpdateParam.getSummary());
        post.setUrl(postUpdateParam.getUrl());
        post.setTitle(postUpdateParam.getTitle());
        return postRepository.saveAndFlush(post);
    }

    @Override
    public boolean switchstatus(Integer postid) {
        Post post = postRepository.findById(postid).get();
        if (post.getStatus() == 0)
            post.setStatus(1);
        else post.setStatus(0);
        if (postRepository.saveAndFlush(post).getId()!=null){
            return true;
        }
       return false;
    }

    @Override
    public Post getPostbyid(Integer id) {
        Post post = postRepository.findById(id).get();
        return post;
    }

    @Override
    public Long getposts() {
        return postRepository.countByDeleted(false)+postRepository.countByDeleted(true);
    }

    @Override
    public Long getthecountofvisits() {
        List<Post> list=postRepository.findAll();
        Long visits = 0L;
        for (Post post:list
             ) {
            visits+=post.getVisits();
        }
        return visits;
    }
}
