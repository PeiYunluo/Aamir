package Aamir.service;

import Aamir.model.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/16 14:12
 */
public interface MiscService {
    List<Integer> findallpostsbytagid(Integer tagid);
    List<Integer> findallpostsbycategoryid(Integer categoryid);
    List<Link> getAlllinks();
    List<Post> getAllpostsbypostid(List<Integer> list, Pageable pageable);
    List<Tag> getAlltagsbydeleted();
    List<Category> getAllcategoriesbydeleted();
    Post findPostbyid(Integer id);
    List<Tag> getAlltagsbypostid(Integer id);
    List<Post> getAllposts();
    List<Comment> getAllcommentsbypostid(Integer id);
    List<Comment> getAllcommentsbypostidandparentid(Integer postid,Integer parentid);
    Boolean addComment(Comment comment);
    Boolean savenewvisit(Post post);
    Comment getOne();
    Post getOnePost();
    Tag getTagbyid(Integer id);
    Boolean wechatNotification();
    //List<Post> getAllpostsbypostid_cate(List<Integer> list, Pageable pageable);
    List getAllPostsByname(String title);
}
