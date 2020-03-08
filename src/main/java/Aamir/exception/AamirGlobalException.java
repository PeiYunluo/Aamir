package Aamir.exception;

import Aamir.model.dto.Result;
import Aamir.model.enums.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/7 10:20
 */
@ControllerAdvice

public class AamirGlobalException {

    @ResponseBody
    @ExceptionHandler(value =Exception.class)
    public String exceptionHandler(Exception e){
        System.out.println("未知异常！原因是:"+e);
        return e.getMessage();
    }
    @ResponseBody
    @ExceptionHandler(value =AamirException.class)
    public Result exceptionHandler(HttpServletRequest httpServletRequest, AamirException e){
        System.out.println("未知异常！原因是:"+e);
        Result result = new Result(Integer.valueOf(e.getResultcode()),e.getMessage());
        return result;
    }
}
