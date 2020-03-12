package Aamir.controller.user;

import Aamir.model.dto.AjaxPutPage;
import Aamir.model.dto.AjaxResultPage;
import Aamir.model.dto.Result;
import Aamir.model.entity.Category;


import Aamir.model.enums.HttpStatus;
import Aamir.model.params.CategoryParam;
import Aamir.service.CategroyService;
import Aamir.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/4 9:22
 */
@Controller
@RequestMapping("/category")
public class CategroyController {
    @Autowired
    private CategroyService categroyService;



    @GetMapping("/gotolist")
    public String gotoCategory(){
        return "adminLayui/category-list";
    }

    //TODO 优化 一次传入一页的数据不用多传
    @ResponseBody
    @GetMapping("/getAll")
    public Result<Category> categoryList(){
        List<Category> list = categroyService.getAll();
        for (Category category:list
             ) {
            if (category.getDeleted()){
                list.remove(category);
            }
        }
        return ResultGenerator.getResultByHttp(HttpStatus.OK,list);
    }

    @ResponseBody
    @GetMapping("/paging")
    public AjaxResultPage<Category> getCategoryList(AjaxPutPage<Category> ajaxPutPage, Category condition){
        Pageable pageable = PageRequest.of(ajaxPutPage.getPage() - 1, ajaxPutPage.getLimit());
        Page<Category> page = categroyService.getCategroies(pageable);
        AjaxResultPage<Category> resultPage = new AjaxResultPage<>();
        resultPage.setData(page.getContent());
        resultPage.setCount(page.getTotalPages());
        return resultPage;
    }

    @ResponseBody
    @PostMapping("/updatename")
    public Result updateCategory(CategoryParam categoryParam){
        boolean flag = categroyService.updateCategroyname(categoryParam);
        if (flag){
            return ResultGenerator.getResultByHttp(HttpStatus.OK);
        }else {
            return ResultGenerator.getResultByHttp(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @ResponseBody
    @PostMapping("/delete")
    public Result deleteCategory(Category category){
        boolean flag = categroyService.deleteCategroybyid(category.getId());
        if (flag){
            return ResultGenerator.getResultByHttp(HttpStatus.OK);
        }
        return ResultGenerator.getResultByHttp(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/gotoadd")
    public String gotoCategoryadd(){
        return "adminLayui/category-add";
    }

    //TODO add
    @ResponseBody
    @PostMapping("/add")
    public Result addCategory(Category category){
        return null;
    }
}
