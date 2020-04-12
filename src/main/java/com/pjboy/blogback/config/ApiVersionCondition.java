package com.pjboy.blogback.config;

import com.pjboy.blogback.annotation.ApiVersion;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自定义url匹配逻辑
 */
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {

  // url 中版本的前缀,这里使用/v[1-9]/的形式
  private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile("v(\\d+)/");

  /* api 版本 */
  private int apiVersion;

  public ApiVersionCondition(int apiVersion) {
    this.apiVersion = apiVersion;
  }

  /**
   * 将不同的筛选条件合并
   *
   * @param apiVersionCondition
   * @return
   */
  @Override
  public ApiVersionCondition combine(ApiVersionCondition apiVersionCondition) {
    //return null;
    return new ApiVersionCondition((apiVersionCondition.getApiVersion()));
  }

  /**
   * 根据request查找匹配到的筛选条件
   *
   * @param httpServletRequest
   * @return
   */
  @Nullable
  @Override
  public ApiVersionCondition getMatchingCondition(HttpServletRequest httpServletRequest) {
    //return null;
    Matcher m = VERSION_PREFIX_PATTERN.matcher(httpServletRequest.getRequestURI());
    if (m.find()) {
      Integer version = Integer.valueOf(m.group(1));
      if (version >= this.apiVersion) {
        return this;
      }
    }
    return null;
  }

  /**
   * 不同筛选条件比较,用于排序
   *
   * @param apiVersionCondition
   * @param httpServletRequest
   * @return
   */
  @Override
  public int compareTo(ApiVersionCondition apiVersionCondition, HttpServletRequest httpServletRequest) {
    //return 0;
    // 优先匹配最新的版本号
    return apiVersionCondition.getApiVersion() - this.apiVersion;
  }

  private int getApiVersion() {
    return apiVersion;
  }
}
