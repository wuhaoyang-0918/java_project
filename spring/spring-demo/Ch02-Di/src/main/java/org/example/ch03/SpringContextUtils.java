package org.example.ch03;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author 昊洋
 * @date:2021-07-30 14:56
 * @PackageName: org.example.ch03
 * @description:
 * @Version 1.0
 */
public class SpringContextUtils implements ApplicationContextAware {
    private static ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.context = applicationContext;
    }
    public static ApplicationContext getContext(){
        return context;
    }
}
