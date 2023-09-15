package com.weelfly.scheduling;

import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.StandardServletEnvironment;

/**
 * 这里是利用分布式锁实现了,不同机器上,同时只运行一个任务
 *
 * @author : shenshuangqing
 */
@Component
public class DemoTask implements EnvironmentAware {

    private StandardServletEnvironment environment;

    @Scheduled(cron = "*/3 * * * * *")
    @SchedulerLock(name = "DemoTask")
    public void test() {
        System.err.println(environment.getPropertySources()
                .get("server.ports")
                .getSource() + " : DemoTask test run ");
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = (StandardServletEnvironment) environment;
    }
}
