package com.pjboy.blogback.authorization.resolvers;

import com.pjboy.blogback.authorization.annotation.CurrentUser;
import com.pjboy.blogback.config.Constants;
import com.pjboy.blogback.entity.TAdmin;
import com.pjboy.blogback.service.TAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * @program: blogback
 * @description: 增加方法注入，将含有 CurrentUser 注解的方法参数注入当前登录用户
 * @author: BLADE
 * @create: 2020-04-22 11:47
 **/
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

  @Autowired
  TAdminService tAdminService;

  @Override
  public boolean supportsParameter(MethodParameter methodParameter) {
    // 如果参数类型是 admin 并且有 CurrentUser 注解
    if (methodParameter.getParameterType().isAssignableFrom(TAdmin.class) && methodParameter.hasParameterAnnotation(CurrentUser.class)) {
      return true;
    }
    return false;
  }

  @Override
  public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
    Long currentUserId = (Long) nativeWebRequest.getAttribute(Constants.CURRENT_USER_ID, RequestAttributes.SCOPE_REQUEST);
    if (currentUserId != null) {
      // 从数据库查询并返回
      return tAdminService.getById(currentUserId);
    }
    throw new MissingServletRequestPartException(Constants.CURRENT_USER_ID);
  }
}
