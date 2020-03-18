package Aamir.service.Impl;

import Aamir.model.entity.Link;
import Aamir.repository.LinkRepository;
import Aamir.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/14 21:51
 */
@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkRepository linkRepository;

    @Override
    public Page<Link> getLinks(Pageable pageable) {
        Page<Link> linkPage = linkRepository.findAll(pageable);
        return linkRepository.findAll(pageable);
    }

    @Override
    public List<Link> getAlllinks() {
        return linkRepository.findAll();

    }

    @Override
    public Boolean addLink(Link link) {
        if (linkRepository.saveAndFlush(link)!=null)
        return true;
        else return false;
    }

    @Override
    public Boolean deleteLinkbyid(Integer id) {
        Link link = linkRepository.findById(id).get();
        if (link != null){
            link.setDeleted(!link.getDeleted());
            linkRepository.saveAndFlush(link);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateLink(Link link) {
        Link oldlink = linkRepository.findById(link.getId()).get();
        try {
            oldlink.setName(link.getName());
            oldlink.setUrl(link.getUrl());
            oldlink.setDescription(link.getDescription());
            oldlink.setLogo(link.getLogo());
            linkRepository.saveAndFlush(oldlink);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
