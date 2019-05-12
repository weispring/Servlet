package web.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * servlet监听器的注册不是直接注册在事件源上，而是由WEB容器负责注册，
 * 开发人员只需在web.xml文件中使用<listener>标签配置好监听器，
 *
 * 监听对象的创建和销毁
 * HttpSessionListener、ServletContextListener、ServletRequestListener分别监控着
 * Session、Context、Request对象的创建和销毁
 *
 * HttpSessionListener(可以用来收集在线者信息)
 * ServletContextListener(可以获取web.xml里面的参数配置)
 * ServletRequestListener
 *
 * 监听Session内的对象
 * 除了上面的6种Listener，还有两种Linstener监听Session内的对象，
 * 分别是HttpSessionBindingListener和HttpSessionActivationListener，
 * 实现这两个接口并不需要在web.xml文件中注册
 *
 * 实现HttpSessionBindingListener接口，JavaBean 对象可以感知自己被绑定到
 * Session 中和从 Session 中删除的事件【和HttpSessionAttributeListener的作用是差不多的】
 * 实现HttpSessionActivationListener接口， * JavaBean 对象可以感知自己被活化和钝化的事件
 * （当服务器关闭时，会将Session的内容保存在硬盘上【钝化】，当服务器开启时，
 * 会将Session的内容在硬盘式重新加载【活化】）
 *
 *
 * @Auther: lixianchun
 * @Date: 2019/5/12 17:38
 * @Description:
 */

@Slf4j
public class ListenerObject implements ServletContextListener,
        HttpSessionListener, ServletRequestListener {

    // Public constructor is required by servlet spec
    public ListenerObject() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        log.info("容器创建了");
    }

    public void contextDestroyed(ServletContextEvent sce) {

        log.info("容器销毁了");
    }

    public void sessionCreated(HttpSessionEvent se) {

        log.info("Session创建了");
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("Session销毁了");
    }


    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        log.info("请求对象销毁:{}",servletRequestEvent);
    }

    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        log.info("请求对象创建:{}",servletRequestEvent);
    }


}
