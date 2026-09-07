package com.lan.exception;


import com.lan.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handlerException(Exception e){
        log.error("全局异常处理器捕获异常信息-",e);
        return Result.error("出错了，请联系管理员");
    }

    @ExceptionHandler
    public Result handerDuplicateKeyException(DuplicateKeyException e){
        log.error("全局异常处理器捕获异常信息-",e);
        String message = e.getMessage();//获取异常信息
        int i = message.indexOf("Duplicate entry");
        String errMsg = message.substring(i);//截取关键信息
        String[] s = errMsg.split(" ");
        return Result.error( s[2] + "已存在");
    }

}
