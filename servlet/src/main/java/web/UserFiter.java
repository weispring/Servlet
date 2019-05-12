package web;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Auther: lixianchun
 * @Date: 2019/5/12 11:02
 * @Description:
 */
@Slf4j
public class UserFiter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    public void destroy() {
        // TODO Auto-generated method stub

    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        //获取HttpSession对象，判断是否登陆
        HttpServletRequest req =  (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        // 如果有下一个过滤器则跳转到下一个过滤器否则目标页面
        log.info("拦截器:begin");
        chain.doFilter(request, response);
        log.info("拦截器:end");
    }

}

