package com.aliyun.rtc.whiteboard.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

/**
 * Http请求工具类
 */
@Slf4j
public class RequestUtil {

    /**
     * 解析HttpServletRequest到入参bean
     * @param request HttpServletRequest
     * @param paramObject 入参bean
     */
    public static void requestToParamObject(HttpServletRequest request, Object paramObject){
        try {
            BeanUtils.populate(paramObject, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error("requestToParamObject: BeanUtils populate Error", e);
        }
    }
}
