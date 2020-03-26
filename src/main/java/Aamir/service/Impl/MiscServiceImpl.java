package Aamir.service.Impl;

import Aamir.model.entity.*;
import Aamir.model.wechat.WechatTokenResponse;
import Aamir.repository.*;
import Aamir.service.MiscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

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

    @Autowired
    private AamirConfigRepository aamirConfigRepository;
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


    @Override
    public Tag getTagbyid(Integer id) {
        return tagRepository.findById(id).get();
    }

    @Override
    public Boolean wechatNotification() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String appid = "appid="+aamirConfigRepository.findByConfigfieldAndAndConfigname("WeChattest","AppID").getConfigvalue();
            String secret = "secret="+aamirConfigRepository.findByConfigfieldAndAndConfigname("WeChattest","AppSecret").getConfigvalue();
            String gettoken = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential"+"&"+appid+"&"+secret;
            WechatTokenResponse wechatTokenResponse =  restTemplate.getForObject(gettoken,WechatTokenResponse.class);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.valueOf("application/json;UTF-8"));
            Map<String,String> map = new HashMap<>();
            String touser = aamirConfigRepository.findByConfigfieldAndAndConfigname("WeChattest","Openid").getConfigvalue();
            String template_id = aamirConfigRepository.findByConfigfieldAndAndConfigname("WeChattest","templateid").getConfigvalue();
            map.put("touser",touser);
            map.put("template_id",template_id);
            HttpEntity requestEntity = new HttpEntity(map,headers);
            String accesstoken = "access_token"+"="+wechatTokenResponse.getAccess_token();
            String posturl = "https://api.weixin.qq.com/cgi-bin/message/template/send?"+accesstoken;
            //WechatTokenResponse wechatTokenResponse =  restTemplate.getForObject("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxe4e3b8dcb1ca8952&secret=21b8896b55f7db7cce1724c4fe00519f",WechatTokenResponse.class);
            String string = restTemplate.postForObject(posturl,requestEntity,String.class);
            return true;
        } catch (Exception e){
            return false;
        }

    }
}
