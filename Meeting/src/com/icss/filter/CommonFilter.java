package com.icss.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: YXh
 * @create: 2021/12/7
 * @Description:
 * @FileName: CommonFilter
 * @History:
 */
//过滤所有的请求  包括请求响应和请求静态资源
@WebFilter("/*")
public class CommonFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //将请求和响应转为子接口类型
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //统一设置请求和响应的编码格式
        request.setCharacterEncoding("utf-8");
        String method = request.getMethod();
        if ("post".equals(method)) {
            //post请求需要重新定义请求编码
            response.setContentType("text/html;charset=utf-8");
        }
        //实现登录访问控制
        //获取请求uri
        String uri = request.getRequestURI();
        System.out.println("uri:" + uri);
        //获取web应用的根目录路径
        String context = request.getContextPath();
        System.out.println("context:" + context);
        if (!uri.equals(context + "/login.html")
                && !uri.equals(context + "/")
                && !uri.equals(context + "/UserLoginServlet")
                && !uri.startsWith(context + "/css")
                && !uri.startsWith(context + "/js")
                && !uri.startsWith(context + "/fonts")
                && !uri.startsWith(context + "/img")) {
            //判断用户是否登录
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            if (username == null) {
                //判断是ajax请求还是普通请求
                if (request.getHeader("X-Requested-With") != null &&
                        request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")) {
                    //通知浏览器session超时   设置一个特殊的报头信息，让前端自己做判断
                    response.setHeader("sessionStatus", "timeout");
                    System.err.println("Error-用户未登录就访问隐私页面，直接跳转到登录");
                } else {
                    response.sendRedirect(context + "/login.html");
                    System.err.println("Error-用户未登录就访问隐私页面，直接跳转到登录");
                }
                return;
            }
        }

        //吐过没有问题则放行请求
        filterChain.doFilter(servletRequest, servletResponse);


    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
