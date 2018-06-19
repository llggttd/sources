package top.crazyman.quick.controller;

import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author <a href="liuguotao@zuozh.com">Guotao.Liu</a>
 * @date Create on 2018/5/10
 * @since version 1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
@RestController
public class BaseController {

    private Map<String, Object> error(String code, String method, String message) {
        HashMap<String, Object> map = new HashMap<>(3);
        map.put("code", code);
        map.put("method", method);
        map.put("message", message);
        return map;
    }

    @ExceptionHandler
    public Map<String, Object> parameterExceptionHandler(Exception e, HandlerMethod handler) {
        return error("1", handler.getMethod().getName(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Map<String, Object> runtimeExceptionHandler(RuntimeException e, HandlerMethod handler) {
        return error("2", handler.getMethod().getName(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e, HandlerMethod handler) {
        return error("3", handler.getMethod().getName(), e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    public Map<String, Object> bindExceptionHandler(BindException e, HandlerMethod handler) {
        return error("4", handler.getMethod().getName(), e.getMessage());
    }
}
