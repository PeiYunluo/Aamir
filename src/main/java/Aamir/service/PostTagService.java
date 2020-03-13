package Aamir.service;

import Aamir.model.entity.PostTag;
import Aamir.model.entity.Tag;


import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/11 21:54
 */
public interface PostTagService {
    List<Tag> getAlltags(List<Integer> list);
    PostTag add(Integer postid, Integer tagid);
    List<Integer> getTagsidbyid(Integer postid);
    boolean isexist(Integer postid, Integer tagid);
}
