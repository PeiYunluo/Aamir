package Aamir.service.Impl;

import Aamir.model.entity.PostCategory;
import Aamir.model.entity.PostTag;
import Aamir.repository.PostCategoryRepository;
import Aamir.service.PostCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/11 21:55
 */
@Service
public class PostCategoryServiceImpl implements PostCategoryService {
    @Autowired
    private PostCategoryRepository postCategoryRepository;
    @Override
    public PostCategory add(Integer postid, Integer categoryid) {
        PostCategory postCategory = new PostCategory();
        postCategory.setCategoryId(categoryid);
        postCategory.setPostId(postid);
        return postCategoryRepository.saveAndFlush(postCategory);
    }

    @Override
    public List<Integer> getCategoriesidbyid(Integer postid) {
        List<Integer> integerList = new ArrayList<>();
        List<PostCategory> postTagList =postCategoryRepository.findAll();
        for (PostCategory postCategory:postTagList
        ) {
            if (postCategory.getPostId()==postid&&postCategory.getDeleted()!=true){
                integerList.add(postCategory.getCategoryId());
            }
        }
        return integerList;
    }

    @Override
    public boolean isexist(Integer postid, Integer categoryid) {
        if (postCategoryRepository.existsByPostIdAndCategoryId(postid,categoryid))
            return true;
        else return false;
    }

    @Override
    public boolean deletePostCatebypostid(Integer postid) {
        List<PostCategory> postCategoryList = postCategoryRepository.findAllByPostId(postid);
        for (PostCategory postcategory:postCategoryList
             ) {
            postCategoryRepository.deleteById(postcategory.getId());
        }
        return true;
    }
}
