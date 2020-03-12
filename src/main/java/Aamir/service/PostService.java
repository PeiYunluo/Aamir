package Aamir.service;

import Aamir.model.entity.Post;
import Aamir.model.params.PostSaveParam;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/11 16:07
 */
public interface PostService {
    Post saveandupdatePost(PostSaveParam postSaveParam);
}
