package com.huifer.baseweb.intercepter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class HttpServletRequestFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    // 防止流读取一次后就没有了, 所以需要将流继续写出去
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    ServletRequest requestWrapper = new BodyReaderHttpServletRequestWrapper(httpServletRequest);
    filterChain.doFilter(requestWrapper, servletResponse);
  }

  @Override
  public void destroy() {

  }
}