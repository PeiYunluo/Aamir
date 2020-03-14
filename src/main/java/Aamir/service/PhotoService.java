package Aamir.service;

import Aamir.model.entity.Photo;

import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/14 15:57
 */
public interface PhotoService {
    boolean savePhoto(Photo photo);
    List<String> getAllPhotosurl();
}
