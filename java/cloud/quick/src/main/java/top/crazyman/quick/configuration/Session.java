package top.crazyman.quick.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * Description:
 *
 * @author <a href="liuguotao@zuozh.com">Guotao.Liu</a>
 * @date Create on 2018/5/10
 * @since version 1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
@EnableSpringHttpSession
public class Session {

    private static int MAX_INACTIVE_INTERVAL = 24 * 60 * 60 * 7;

    @Bean
    CookieSerializer cookieSerializer() {
        DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
        cookieSerializer.setCookieMaxAge(MAX_INACTIVE_INTERVAL);
        return cookieSerializer;
    }

    @Bean
    MapSessionRepository sessionRepository() {
        MapSessionRepository sessionRepository = new MapSessionRepository();
        sessionRepository.setDefaultMaxInactiveInterval(MAX_INACTIVE_INTERVAL);
        return sessionRepository;
    }
}
