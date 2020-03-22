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
import java.util.Random;

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

    //TODO:
    @Override
    public List<Post> getAllposts() {
        return postRepository.findAll();
    }

    //验证是否删除及其是否通过审核无父亲评论号码
    @Override
    public List<Comment> getAllcommentsbypostid(Integer id) {
        return commentRepository.findAllByPostIdAndStatusAndDeletedAndParentId(id,1,false,0);
    }

    @Override
    public List<Comment> getAllcommentsbypostidandparentid(Integer postid, Integer parentid) {
        return commentRepository.findAllByPostIdAndStatusAndDeletedAndParentId(postid,1,false,parentid);
    }

    //判断是否允许
    @Override
    public Boolean addComment(Comment comment) {
        if (postRepository.findById(comment.getPostId()).get().getDisallowComment()==false){
            if ((comment.getAuthor() != null && comment.getAuthor() !="")
                    && (comment.getEmail() !=null && comment.getEmail() !="")
                    && (comment.getContent() !=null && comment.getContent() !="")
                    && (comment.getPostId() !=null && comment.getPostId()!= 0)){
                commentRepository.saveAndFlush(comment);
                return true;
            } else
                return false;
        }

    return false;
    }

    @Override
    public Boolean savenewvisit(Post post) {
        postRepository.saveAndFlush(post);
        return true;
    }


    @Override
    public Comment getOne() {

        try {
            List<Comment> list = commentRepository.findAllByAllowNotification(true);
            Random random =new Random();
            Integer integer = random.nextInt(list.size());
            return list.get(integer);
        } catch (Exception e){
            List<Comment> list = commentRepository.findAllByAllowNotification(false);
            Random random =new Random();
            Integer integer = random.nextInt(list.size());
            return list.get(integer);
        }

    }

    @Override
    public Post getOnePost() {
        try {
            List<Post> list = postRepository.findAllByDeletedAndStatus(false,1);
            Random random =new Random();
            Integer integer = random.nextInt(list.size());
            return list.get(integer);
        } catch (Exception e){
            List<Post> list = postRepository.findAllByDeletedAndStatus(true,1);
            Random random =new Random();
            Integer integer = random.nextInt(list.size());
            return list.get(integer);
        }

    }
}
