package web.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * 监听对象属性变化
 * ServletContextAttributeListener、HttpSessionAttributeListener、ServletRequestAttributeListener
 * 分别监听着Context、Session、Request对象属性的变化
 *
 * 这三个接口中都定义了三个方法来处理被监听对象中的属性的增加，删除和替换的事件，
 * 同一个事件在这三个接口中对应的方法名称完全相同，只是接受的参数类型不同。
 *
 * attributeAdded()
 * attributeRemoved()
 * attributeReplaced()
 *
 *
 * @Auther: lixianchun
 * @Date: 2019/5/12 17:43
 * @Description:
 */
@Slf4j
@WebListener
public class ListenerAttribute implements ServletContextAttributeListener {

    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        log.info("Context对象增加了属性");
    }
    
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        log.info("Context对象删除了属性");
    }
    
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        log.info("Context对象替换了属性");
    }
    
}
