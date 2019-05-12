package web;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Servlet implementation class CountFilter
 */
/**
 * @Auther: lixianchun
 * @Date: 2019/5/12 09:28
 * @Description:
 */
@Slf4j
@WebServlet("/CountFilter")
public class CountFilter extends HttpServlet implements Filter {
    private static final long serialVersionUID = 1L;
    //来访数量
    private AtomicInteger count = new AtomicInteger(0);

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig filterConfig) throws javax.servlet.ServletException {
        // TODO Auto-generated method stub
        String param=filterConfig.getInitParameter("count");//获取初始化参数
        count.set(Integer.valueOf(param));//将字符串转换为int
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, javax.servlet.ServletException {
        // TODO Auto-generated method stub
        count.incrementAndGet();//访问数量自增
        //将ServletRequest转换成HttpServletRequest
        HttpServletRequest req=(HttpServletRequest)request;
        //获取ServletContext
        ServletContext context=req.getSession().getServletContext();

        /**
         * ServletContext官方叫servlet上下文。服务器会为每一个工程创建一个对象，这个对象就是ServletContext对象。
         * 这个对象全局唯一，而且工程内部的所有servlet都共享这个对象。所以叫全局应用程序共享对象。
         * 所以下面做法有问题
         */

        context.setAttribute("count", count.get());//将来访数量值放入到ServletContext中

        log.info("过滤器:begin");
        chain.doFilter(request, response);//向下传递过滤器
        log.info("过滤器:end");


    }


    /**
     * @see Servlet#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }


}
