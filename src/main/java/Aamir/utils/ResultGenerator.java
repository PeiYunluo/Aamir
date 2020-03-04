package Aamir.utils;

import Aamir.model.dto.Result;
import Aamir.model.enums.HttpStatus;
import org.springframework.util.StringUtils;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/3 17:59
 */
public class ResultGenerator {

    public static Result genSuccessResult() {
        Result result = new Result();
        result.setResultCode(HttpStatus.OK.getStatus());
        result.setMessage(HttpStatus.OK.getContent());
        return result;
    }

    public static Result genSuccessResult(String message) {
        Result result = new Result();
        result.setResultCode(HttpStatus.OK.getStatus());
        result.setMessage(message);
        return result;
    }

    public static Result genSuccessResult(Object data) {
        Result result = new Result();
        result.setResultCode(HttpStatus.OK.getStatus());
        result.setMessage(HttpStatus.OK.getContent());
        result.setData(data);
        return result;
    }

    public static Result genFailResult(String message) {
        Result result = new Result();
        result.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR.getStatus());
        if (StringUtils.isEmpty(message)) {
            result.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getContent());
        } else {
            result.setMessage(message);
        }
        return result;
    }

    public static Result genErrorResult(int code, String message) {
        Result result = new Result();
        result.setResultCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * @Description: 根据传入的常量和data数据返回对应result
     * @Param: [constants] http状态
     * @return: com.zhulin.blog.dto.Result
     * @date: 2019/8/24 16:25
     */
    public static Result getResultByHttp(HttpStatus constants,Object data){
        Result result = ResultGenerator.genErrorResult(constants.getStatus(), constants.getContent());
        result.setData(data);
        return result;
    }

    /**
     * @Description: 根据传入的常量返回对应result
     * @Param: [constants] http状态
     * @return: com.zhulin.blog.dto.Result
     * @date: 2019/8/24 16:25
     */
    public static Result getResultByHttp(HttpStatus constants){
        Result result = ResultGenerator.genErrorResult(constants.getStatus(), constants.getContent());
        return result;
    }
}

