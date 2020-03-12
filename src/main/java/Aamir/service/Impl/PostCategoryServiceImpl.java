package Aamir.service.Impl;

import Aamir.model.entity.PostCategory;
import Aamir.repository.PostCategoryRepository;
import Aamir.service.PostCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
