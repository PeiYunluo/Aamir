package Aamir.service.Impl;

import Aamir.model.entity.Category;
import Aamir.model.params.CategoryParam;
import Aamir.repository.CategoryRepository;
import Aamir.service.CategroyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/5 10:02
 */
@Service
public class CategroyServiceImpl implements CategroyService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> getCategroies(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Boolean deleteCategroybyid(Integer id) {
        Category category = categoryRepository.findById(id).get();
        if ( category!=null){
            category.setDeleted(!category.getDeleted());
            categoryRepository.saveAndFlush(category);
            return true;
        }
        else
            return false;
    }

    //TODO 新增
    @Override
    public Boolean saveCategroy(Category category) {
        if(category.getCategroyname()!=null || category.getCategroyname()!=""){
            categoryRepository.saveAndFlush(category);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateCategroyname(CategoryParam categoryParam) {
        Category category = categoryRepository.findById(categoryParam.getId()).get();
        if (categoryParam.getCategroyname()!=null&&categoryParam.getCategroyname()!=""){
            category.setCategroyname(categoryParam.getCategroyname());

        }
        if (categoryParam.getCategroyrank()!=null){
            category.setCategroyrank(categoryParam.getCategroyrank());
        }
        if (categoryParam.getIcon()!=null&&categoryParam.getIcon()!=""){
            category.setIcon(categoryParam.getIcon());
            categoryRepository.saveAndFlush(category);
            return true;
        }
        return false;
    }
}
