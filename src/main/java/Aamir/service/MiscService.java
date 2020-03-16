package Aamir.service;

import Aamir.model.entity.Link;
import Aamir.model.entity.Post;
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
    //List<Post> getAllpostsbypostid_cate(List<Integer> list, Pageable pageable);
}
