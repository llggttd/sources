/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.project.controller.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.example.project.common.HttpResult;
import com.example.project.common.enums.ResultCodeEnum;

/**
 * @author Guotao.Liu
 * @version : ActionAdapter.java, v 0.1 2020-05-09 16:12 lgt Exp $
 */
@Component
public class ActionAdapter implements ApplicationContextAware {

    private final static Logger           logger  = LoggerFactory.getLogger(ActionAdapter.class);

    private final Map<ActionMeta, Action> actions = new HashMap<>();

    private Action deduceAction(ActionMeta action) {
        return actions.get(action);
    }

    public HttpResult<?> action(HttpServletRequest request, HttpServletResponse response) {

        String actionName = request.getParameter(ParamConstant.ACTION);
        String data = request.getParameter(ParamConstant.DATA);
        Action action = deduceAction(ActionMeta.getByName(actionName));
        ActionResult actionResult;
        try {
            actionResult = action.execute(data);
        } catch (Exception e) {
            return HttpResult.build(ResultCodeEnum.EXCEPTION.getCode(),
                ResultCodeEnum.EXCEPTION.getMsg());
        }
        return HttpResult.build(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg(),
            actionResult);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Class<? extends ActionHandle> annotationClass = ActionHandle.class;
        Map<String, Object> beansWithAnnotation = applicationContext
            .getBeansWithAnnotation(annotationClass);
        for (Map.Entry<String, Object> entry : beansWithAnnotation.entrySet()) {
            ActionHandle annotation = entry.getValue().getClass().getAnnotation(annotationClass);
            actions.put(annotation.value(), (Action) entry.getValue());
        }
    }
}
