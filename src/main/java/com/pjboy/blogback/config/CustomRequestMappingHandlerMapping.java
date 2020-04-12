package com.pjboy.blogback.config;

import com.pjboy.blogback.annotation.ApiVersion;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * 自定义匹配的处理器
 * 重写RequestMappingHandlerMapping类的一些方法
 */
public class CustomRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
  @Override
  protected RequestCondition<ApiVersionCondition> getCustomTypeCondition(Class<?> handlerType) {
    ApiVersion apiVersion = AnnotationUtils.findAnnotation(handlerType, ApiVersion.class);
    return createCondition(apiVersion);
  }

  private RequestCondition<ApiVersionCondition> createCondition(ApiVersion apiVersion) {
    return apiVersion == null ? null : new ApiVersionCondition(apiVersion.value());
  }
}
