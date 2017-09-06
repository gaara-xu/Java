package com.src.handle;

import com.src.domain.Result;
import com.src.exception.GirlException;
import com.src.utils.ResultUtil;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import org.slf4j.Logger;

/**
 * Created by Gaara_Xu
 * on 2017/9/6.
 */
@ControllerAdvice
public class ExceptionHandle {

    public final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = GirlException.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof GirlException ){
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else{
            logger.error("【系统异常】",e);
            return ResultUtil.error(-1,"未知错误");
        }
    }
}
