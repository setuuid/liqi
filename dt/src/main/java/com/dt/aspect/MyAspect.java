package com.dt.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.logging.Logger;

/**
 * @program: dt
 * @description: 日志
 * @author: liqi
 * @create: 2019-07-04 14:33
 */
@Aspect
@Component
public class MyAspect {
    private static Logger logger = (Logger) LoggerFactory.getLogger(MyAspect.class);

    /**
     * 切入点  controller下的所有类，类下的所有方法，方法下的所有参数（..）
     */
    @Pointcut("execution(* com.dt.sys.*.controller.*.*(..))")
    public  void webLog(){

    }

    /**
     *前置通知
     */
    @Before("webLog()")
    public void myBefore(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes= (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        //请求资源路径
        logger.info("URL{}:"+request.getRequestURL());
        logger.info("METHOD{}:"+request.getMethod());
        logger.info("REMOTEADDR{}:"+request.getRemoteAddr());
        logger.info("PORT{}:"+request.getRemotePort());
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String paramName = parameterNames.nextElement();
            logger.info("name{}:"+paramName);

        }

    }

    /**
     * 后置  --拿到请求接口返回值
     * @param ret
     */
    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void myAfter(String ret){
        logger.info("returnValue{}:"+ret);
    }
}
