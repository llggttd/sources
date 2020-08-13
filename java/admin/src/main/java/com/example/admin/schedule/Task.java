/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author Guotao.Liu
 * @version : Task.java, v 0.1 2020-08-07 10:52 lgt Exp $
 */
@Configuration
@EnableScheduling
public class Task {

    private final static Logger logger = LoggerFactory.getLogger(Task.class);

    @Scheduled(cron = "0/10 * * * * ?")
    private void query() {
        logger.info("task run...");
    }
}
