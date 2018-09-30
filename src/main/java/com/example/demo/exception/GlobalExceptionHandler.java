package com.example.demo.exception;

import com.example.demo.result.CodeMsg;
import com.example.demo.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    public Result<String> bindExceptionHandler(Exception e){
        LOG.error("Exception在GlobalExceptionHandler中被捕获 ----> ",e);
        if (e instanceof BindException) {
            List<ObjectError> allErrors = ((BindException)e).getAllErrors();
            StringBuilder errorMsgs = new StringBuilder();
            for (ObjectError allError : allErrors) {
                errorMsgs.append(allError.getDefaultMessage());
            }
            return Result.error(CodeMsg.BIND_ERROR.filterMsg(errorMsgs.toString()));
        }else if (e instanceof GlobalException){
            GlobalException globalException = (GlobalException) e;
            CodeMsg codeMsg = globalException.getCodeMsg();
            return Result.error(codeMsg);
        }else {
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

}
