package Aamir.service;

import Aamir.model.entity.Link;
import org.springframework.data.domain.Page;


import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/14 21:50
 */
public interface LinkService {
    Page<Link> getLinks(Pageable pageable);

    List<Link> getAlllinks();

    Boolean addLink(Link link);

    Boolean deleteLinkbyid(Integer id);

    Boolean updateLink(Link link);
}
