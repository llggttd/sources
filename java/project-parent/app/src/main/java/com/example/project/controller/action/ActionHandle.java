package com.example.project.controller.action;

import java.lang.annotation.*;

import org.springframework.stereotype.Component;

/**
 * @author Guotao.Liu
 * @version : ActionHandle.java, v 0.1 2020-05-09 17:55 lgt Exp $
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface ActionHandle {

    /**
     * action枚举
     * @return  action枚举
     */
    ActionMeta value();
}
