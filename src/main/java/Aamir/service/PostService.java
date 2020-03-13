package Aamir.service;

import Aamir.model.dto.PostDTO;
import Aamir.model.entity.Post;
import Aamir.model.params.PostSaveParam;
import Aamir.model.params.PostUpdateParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/11 16:07
 */
public interface PostService {
    Post saveandupdatePost(PostSaveParam postSaveParam);
    Page<Post> getPosts(Pageable pageable);
    Page<PostDTO> getPostDTOs(Pageable pageable);
    boolean deletePostbyid(Integer postid);
    boolean switchComment(Integer postid);
    Post updatePost(PostUpdateParam postUpdateParam);
    boolean switchstatus(Integer postid);
}
