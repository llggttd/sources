/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.AvailabilityState;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Guotao.Liu
 * @version : ApplicationAvailabilityListener.java, v 0.1 2020-08-07 15:27 lgt Exp $
 */
@Component
public class ApplicationAvailabilityListener implements
                                             ApplicationListener<AvailabilityChangeEvent<?>> {

    private final static Logger logger = LoggerFactory
        .getLogger(ApplicationAvailabilityListener.class);

    @Override
    public void onApplicationEvent(AvailabilityChangeEvent event) {
        AvailabilityState state = event.getState();
        if (event.getState() instanceof LivenessState) {
            logger.info("event[AvailabilityChangeEvent], state[{}]", state.toString());
        } else if (event.getState() instanceof ReadinessState) {
            logger.info("event[AvailabilityChangeEvent], state[{}]", state.toString());
            if (ReadinessState.ACCEPTING_TRAFFIC == event.getState()) {
                applicationReady();
            }
        } else {
            logger.info("unknown event {}", event);
        }
    }

    private void applicationReady() {

    }

}
