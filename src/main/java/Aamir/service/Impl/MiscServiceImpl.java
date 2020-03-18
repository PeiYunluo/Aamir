package Aamir.service.Impl;

import Aamir.model.entity.*;
import Aamir.repository.*;
import Aamir.service.MiscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/16 14:12
 */
@Service
public class MiscServiceImpl implements MiscService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostTagRepository postTagRepository;
    @Autowired
    private PostCategoryRepository postCategoryRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private LinkRepository linkRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Integer> findallpostsbytagid(Integer tagid) {
        List<PostTag> postTagList = postTagRepository.findAllByTagId(tagid);
        List<Integer> integerList = new ArrayList<>();
        for (PostTag postTag:postTagList
             ) {
            if (postTag.getDeleted()!=true){
                integerList.add(postTag.getPostId());
            }
        }
        return integerList;
    }

    @Override
    public List<Integer> findallpostsbycategoryid(Integer categoryid) {
        List<PostCategory> postCategoryList = postCategoryRepository.findAllByCategoryId(categoryid);
        List<Integer> integerList = new ArrayList<>();
        for (PostCategory postCategory :postCategoryList
                ) {
            if (postCategory.getDeleted()!=true){
                integerList.add(postCategory.getPostId());
            }
        }
        return integerList;
    }

    @Override
    public List<Link> getAlllinks() {
        List<Link> links = linkRepository.findAll();
        List<Link> newlinks = new ArrayList<>();
        for (Link link:links
             ) {
            if (link.getDeleted()==true){

            } else newlinks.add(link);
        }
        return newlinks;
    }

    @Override
    public List<Post> getAllpostsbypostid(List<Integer> list, Pageable pageable) {
        return postRepository.findAllById(list);
    }


    @Override
    public List<Tag> getAlltagsbydeleted() {
        return tagRepository.findAllByDeleted(false);
    }

    @Override
    public List<Category> getAllcategoriesbydeleted() {
        return categoryRepository.findAllByDeleted(false);
    }

    @Override
    public Post findPostbyid(Integer id) {
        return postRepository.findById(id).get();
    }

    //TODO
    @Override
    public List<Tag> getAlltagsbypostid(Integer id) {
        return null;
    }
}
