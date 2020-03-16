package Aamir.service;

import Aamir.model.entity.AamirConfig;

import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/14 21:50
 */
public interface AamirConfigService {
    Boolean modifyOptionbyid(AamirConfig aamirConfig);
    List<AamirConfig> getAllOptions();
    AamirConfig findbynameadnfield(String field,String name);
}
