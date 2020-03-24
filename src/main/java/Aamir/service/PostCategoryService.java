package Aamir.service;

import Aamir.model.entity.PostCategory;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/11 21:55
 */
public interface PostCategoryService {
    PostCategory add(Integer postid,Integer categoryid);
    List<Integer> getCategoriesidbyid(Integer postid);
    boolean isexist(Integer postid, Integer categoryid);
    boolean deletePostCatebypostid(Integer postid);
}
