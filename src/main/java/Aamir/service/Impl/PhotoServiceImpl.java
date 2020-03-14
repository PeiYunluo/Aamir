package Aamir.service.Impl;

import Aamir.model.entity.Photo;
import Aamir.repository.PhotoRepository;
import Aamir.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/14 15:58
 */
@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public boolean savePhoto(Photo photo) {
        if (photoRepository.saveAndFlush(photo) != null) {
            return true;
        } else
            return false;
    }

    @Override
    public List<String> getAllPhotosurl() {
        List<String> stringList = new ArrayList<>();
        List<Photo> photoList = photoRepository.findAll();
        for (Photo photo:photoList
             ) {
            stringList.add(photo.getUrl());
        }
        return stringList;
    }
}