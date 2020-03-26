package Aamir.controller.items;

import Aamir.model.dto.CommentDTO;
import Aamir.model.dto.Result;
import Aamir.model.entity.*;
import Aamir.model.enums.HttpStatus;
import Aamir.model.params.miscParams.CategoryPageParam;
import Aamir.model.params.miscParams.TagPageParam;
import Aamir.model.wechat.WechatTokenResponse;
import Aamir.service.*;
import Aamir.utils.MarkdownUtils;
import Aamir.utils.PageUtils;
import Aamir.utils.ResultGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/16 13:49
 */
@RequestMapping("/misc")
@Controller
public class MiscController {

    @Autowired
    private MiscService miscService;
    @Autowired
    private PostTagService postTagService;
    @Autowired
    private TagService tagService;
    @Autowired
    private PostService postService;
    @Autowired
    private AamirConfigService aamirConfigService;
    @Autowired
    private MailService mailService;
    @Autowired
    private UserService userService;

    RestTemplate restTemplate = new RestTemplate();


    @GetMapping("/fetchAllpostsBytagid")
    @ResponseBody
    public Result fetchAllpostsBytagid(TagPageParam tagPageParam) {
        Pageable pageable = PageRequest.of(tagPageParam.getPage() - 1, tagPageParam.getLimit());
        List<Integer> integerList = miscService.findallpostsbytagid(tagPageParam.getId());
        List<Post> list = miscService.getAllpostsbypostid(integerList, pageable);
        //去除已删除
        List<Post> newlist = new ArrayList<>();
        for (Post post : list
        ) {
            if (post.getDeleted() == true || post.getStatus() == 0) {

            } else newlist.add(post);
        }
        Page<Post> postPage = PageUtils.listConvertToPage(newlist, pageable);
        return ResultGenerator.getResultByHttp(HttpStatus.OK, postPage.getContent());
    }


    @GetMapping("/fetchAllpostsBycategoryid")
    @ResponseBody
    public Result fetchAllpostsBycategoryid(CategoryPageParam categoryPageParam) {
        Pageable pageable = PageRequest.of(categoryPageParam.getPage() - 1, categoryPageParam.getLimit());
        List<Integer> integerList = miscService.findallpostsbycategoryid(categoryPageParam.getId());
        List<Post> list = miscService.getAllpostsbypostid(integerList, pageable);
        List<Post> newlist = new ArrayList<>();
        for (Post post : list
        ) {
            if (post.getDeleted() == true || post.getStatus() == 0) {
            } else newlist.add(post);
        }
        Page<Post> postPage = PageUtils.listConvertToPage(newlist, pageable);
        return ResultGenerator.getResultByHttp(HttpStatus.OK, postPage.getContent());
    }


    @GetMapping("/getalltags")
    @ResponseBody
    public Result fetchAlltags() {
        return ResultGenerator.getResultByHttp(HttpStatus.OK, miscService.getAlltagsbydeleted());
    }

    @GetMapping("/getallcategories")
    @ResponseBody
    public Result fetchAllcategories() {
        return ResultGenerator.getResultByHttp(HttpStatus.OK, miscService.getAllcategoriesbydeleted());
    }

    @GetMapping("/getPostbyid")
    @ResponseBody
    public Result fetchOnePostbyid(Integer id) {
        Post post = miscService.findPostbyid(id);
        post.setVisits(post.getVisits() + 1);
        miscService.savenewvisit(post);
        if (post.getDeleted() != true && post.getStatus() == 1) {
            post.setOriginalContent(MarkdownUtils.mdToHtml(post.getOriginalContent()));
            return ResultGenerator.getResultByHttp(HttpStatus.OK, post);
        } else return ResultGenerator.getResultByHttp(HttpStatus.OK, "无此文章");

    }

    //TODO:考虑删除的情况 删除tag时自动将tagpost表置为删除
    //TODO:postcategory 置为删除
    //TODO:考虑同步状态
    @GetMapping("/getAlltagsbypostid")
    @ResponseBody
    public Result fetchAlltagsbypostid(Integer id) {
        List<Integer> tagsid = postTagService.getTagsidbyid(id);

        List<Tag> newtags = new ArrayList<>();
        for (Integer tagid : tagsid
        ) {
            if (tagService.getTagbyid(tagid).getDeleted() != true) {
                newtags.add(tagService.getTagbyid(tagid));
            }
        }
        return ResultGenerator.getResultByHttp(HttpStatus.OK, newtags);
    }

    @GetMapping("/getAllposts")
    @ResponseBody
    public Result fetchAllposts() {
        List<Post> postList = miscService.getAllposts();
        List<Post> newpostList = new ArrayList<>();
        for (Post post : postList
        ) {
            if (post.getDeleted() != true && post.getStatus() == 1) {
                newpostList.add(post);
            }
        }
        return ResultGenerator.getResultByHttp(HttpStatus.OK, newpostList);
    }

    //根据postid拿到所有评论内容
    //根据每个parentid 拿到reply列表
    @GetMapping("/getAllcomments")
    @ResponseBody
    public Result fetchAllcomments(Integer id) {
        List<CommentDTO> commentDTOList = new ArrayList<>();
        List<Comment> commentList = miscService.getAllcommentsbypostid(id);
        for (Comment comment : commentList
        ) {
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setComment(comment);
            commentDTO.setReplycomments(miscService.getAllcommentsbypostidandparentid(id, comment.getId()));
            commentDTOList.add(commentDTO);
        }
        return ResultGenerator.getResultByHttp(HttpStatus.OK, commentDTOList);
    }


    //TODO:变成param
    @PostMapping("/addComment")
    @ResponseBody
    public Result addComment(@RequestBody Comment comment) {

        //TODO
        User user = userService.getUser(1);

        if (miscService.addComment(comment)) {
            AamirConfig aamirConfig = aamirConfigService.findbynameadnfield("QQMail", "email");
            if (aamirConfig.getConfigvalue().equals("TRUE")) {
                mailService.sendSimpleEmail(user.getEmail(), "评论审核", "您有新的评论需要审核");
            }
            AamirConfig aamirConfig1 = aamirConfigService.findbynameadnfield("WeChattest", "notification");

            if (aamirConfig1.getConfigvalue().equals("TRUE")) {
                //TODO wechat逻辑
                //https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxe4e3b8dcb1ca8952&secret=21b8896b55f7db7cce1724c4fe00519f
                //get请求获取token
                //31_3byG7yT5fWcc9DRmFApZUARC3WFzLgoVgP65azwFPVsq7Q5bPFqZf8LHLrKuiHxzlRCSGAeLUZ4qPnnUtHFKcNTLgR022MDjTiRZJYyLxCrlDM4MnSYLLD6ijZ9GgJEyPJMETna7ahsENm9RVASdAAAOTL
                miscService.wechatNotification();
            }
            if (aamirConfig.getConfigvalue().equals("TRUE")) {
                mailService.sendSimpleEmail(user.getEmail(), "评论审核", "您有新的评论需要审核");
            }
            return ResultGenerator.getResultByHttp(HttpStatus.OK, "增加成功");
        }
        return ResultGenerator.getResultByHttp(HttpStatus.BAD_REQUEST, "增加失败");
    }


    @GetMapping("/getAlllinks")
    @ResponseBody
    public Result fetchAlllinks() {
        return ResultGenerator.getResultByHttp(HttpStatus.OK, miscService.getAlllinks());
    }


    @GetMapping("/getOneComment")
    @ResponseBody
    public Result getOneComment() {
        return ResultGenerator.getResultByHttp(HttpStatus.OK, miscService.getOne());
    }

    @GetMapping("/getOnePost")
    @ResponseBody
    public Result getOnePost() {
        return ResultGenerator.getResultByHttp(HttpStatus.OK, miscService.getOnePost());
    }

    @GetMapping("/getTagbyid")
    @ResponseBody
    public Result fetchTagbyid(Integer tagid) {
        return ResultGenerator.getResultByHttp(HttpStatus.OK, miscService.getTagbyid(tagid));
    }



    @GetMapping("/testWechat")
    @ResponseBody
    public Result testWechat(){
        RestTemplate restTemplate = new RestTemplate();
        String appid = "appid="+aamirConfigService.findbynameadnfield("WeChattest","AppID").getConfigvalue();
        String secret = "secret="+aamirConfigService.findbynameadnfield("WeChattest","AppSecret").getConfigvalue();
        String gettoken = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential"+"&"+appid+"&"+secret;
        WechatTokenResponse wechatTokenResponse =  restTemplate.getForObject(gettoken,WechatTokenResponse.class);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("application/json;UTF-8"));
        Map<String,String> map = new HashMap<>();
        String touser = aamirConfigService.findbynameadnfield("WeChattest","Openid").getConfigvalue();
        String template_id = aamirConfigService.findbynameadnfield("WeChattest","templateid").getConfigvalue();
        map.put("touser",touser);
        map.put("template_id",template_id);
        HttpEntity requestEntity = new HttpEntity(map,headers);
        String accesstoken = "access_token"+"="+wechatTokenResponse.getAccess_token();
        String posturl = "https://api.weixin.qq.com/cgi-bin/message/template/send?"+accesstoken;
        //WechatTokenResponse wechatTokenResponse =  restTemplate.getForObject("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxe4e3b8dcb1ca8952&secret=21b8896b55f7db7cce1724c4fe00519f",WechatTokenResponse.class);
        String string = restTemplate.postForObject(posturl,requestEntity,String.class);
        return ResultGenerator.getResultByHttp(HttpStatus.OK,string);
    }
}
