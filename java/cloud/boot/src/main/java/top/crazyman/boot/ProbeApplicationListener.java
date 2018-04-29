package top.crazyman.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 通过探针监听器，可以监听到application生命周期内的相关事件
 * 这里要注意一下，由于监听器注册的时间会有所滞后，有部分事件无法监听到。
 * 当使用Configuration注解方式，要在ApplicationContext加载后，ApplicationListener Bean才加注册上去，所以之前的
 * 事件无法打印出来；
 *
 * @author 0z0ne
 * @date 2018-04-19
 */
public class ProbeApplicationListener implements ApplicationListener<ApplicationEvent> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        logger.error("├PROBE┤ [{}] --> {}", event.getClass().getSimpleName(), event);
    }

}
