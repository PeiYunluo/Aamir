package Aamir.service.Impl;

import Aamir.model.entity.AamirConfig;
import Aamir.repository.AamirConfigRepository;
import Aamir.service.AamirConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/14 21:52
 */
@Service
public class AamirConfigServiceImpl implements AamirConfigService {
    @Autowired
    private AamirConfigRepository aamirConfigRepository;

    @Override
    public Boolean modifyOptionbyid(AamirConfig aamirConfig) {
        AamirConfig oldconfig = aamirConfigRepository.findById(aamirConfig.getId()).get();
        oldconfig.setConfigvalue(aamirConfig.getConfigvalue());
        if (aamirConfigRepository.saveAndFlush(oldconfig)!=null)
        return true;
        else return false;
    }

    @Override
    public List<AamirConfig> getAllOptions() {
        return aamirConfigRepository.findAll();
    }

    @Override
    public AamirConfig findbynameadnfield(String field,String name) {
        return aamirConfigRepository.findByConfigfieldAndAndConfigname(field,name);

    }

    @Override
    public Boolean switches(String field, String name) {
        try {
            AamirConfig aamirConfig = aamirConfigRepository.findByConfigfieldAndAndConfigname(field,name);
            aamirConfig.setConfigvalue((aamirConfig.getConfigvalue().equals("TRUE"))?"FALSE":"TRUE");
            aamirConfigRepository.saveAndFlush(aamirConfig);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean initAllOptions() {

        return null;
    }
}
