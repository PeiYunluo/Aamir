package Aamir.service;

import Aamir.model.entity.Category;
import Aamir.model.params.CategoryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/5 10:02
 */
public interface CategroyService {
    List<Category> getAll();
    Page<Category> getCategroies(Pageable pageable);
    Boolean deleteCategroybyid(Integer id);
    Boolean saveCategroy(Category category);
    Boolean updateCategroyname(CategoryParam categoryParam);
    Long getcountsofcate();
}
