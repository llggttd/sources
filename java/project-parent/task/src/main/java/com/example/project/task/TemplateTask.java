/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.project.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Guotao.Liu
 * @version : LoanTask.java, v 0.1 2020-05-08 13:40 lgt Exp $
 */
@Component
public class TemplateTask {

    private final static Logger logger = LoggerFactory.getLogger(TemplateTask.class);

    @Scheduled(cron = "0/5 * * * * *")
    public void cron() {
        logger.error("task done");
    }
}
