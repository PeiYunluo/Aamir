package Aamir.service;

import Aamir.model.entity.PostCategory;
import io.swagger.models.auth.In;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/11 21:55
 */
public interface PostCategoryService {
    PostCategory add(Integer postid,Integer categoryid);
}
