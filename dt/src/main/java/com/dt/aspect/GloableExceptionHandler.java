package com.dt.aspect;

import com.dt.common.BaseVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: dt aop
 * @description: 全局处理异常
 * @author: liqi
 * @create: 2019-07-04 14:54
 */
@RestControllerAdvice(basePackages = "com.dt.sys.*.controller")
public class GloableExceptionHandler {
    //有这个@ControllerAdvice  方法记得加@Resposebody
    //发生异常时   这是controller 不用try catch
    //指定处理什么样的异常
    @ExceptionHandler(RuntimeException.class)
    public BaseVo handlers(){
        BaseVo baseVo = new BaseVo();
        baseVo.setCode(1);
        baseVo.setMsg("一同异常");
        return baseVo;
    }
}
