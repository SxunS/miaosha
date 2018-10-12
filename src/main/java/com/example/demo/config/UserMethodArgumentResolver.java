package com.example.demo.config;

import com.example.demo.constant.CookieConstant;
import com.example.demo.entity.MiaoshaUser;
import com.example.demo.service.UserService;
import com.example.demo.util.CookieUtil;
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
public class UserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    UserService userService;
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        Class<?> aClass = methodParameter.getParameterType();
        return MiaoshaUser.class == aClass;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        String paramToken = request.getParameter(CookieConstant.USER_TOKEN);
        String cookieToken = CookieUtil.getValue(request, CookieConstant.USER_TOKEN);
        String token = StringUtils.isNotBlank(paramToken) ? paramToken : cookieToken;
        if (StringUtils.isBlank(token)) {
            return null;
        }
        return userService.getUserFromToken(token);
    }
}
