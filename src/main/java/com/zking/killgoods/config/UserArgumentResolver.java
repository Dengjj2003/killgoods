package com.zking.killgoods.config;

import com.zking.killgoods.exception.BusinessException;
import com.zking.killgoods.model.User;
import com.zking.killgoods.service.IRedisService;
import com.zking.killgoods.util.CookieUtils;
import com.zking.killgoods.util.JsonResponseStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private IRedisService redisService;
    //配暗号：当方法内有指定参数的时候，我们就需要调用该参数解析器
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        //当用户类和当前方法的参数类型匹配的时候，返回为true
        return User.class==methodParameter.getParameterType();
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest req=(HttpServletRequest)nativeWebRequest.getNativeRequest();
        //获取cookie里面的令牌
        String token = CookieUtils.getCookieValue(req, "token");
        if(StringUtils.isEmpty(token)){
            throw new BusinessException(JsonResponseStatus.TOKEN_EMPTY);
        }
        //根据令牌得到对应的user信息
        User user = redisService.getRedis(token);
        if(null==user){
            throw new BusinessException(JsonResponseStatus.TOKEN_USER_EMPTY);
        }

        return user;
    }
}
