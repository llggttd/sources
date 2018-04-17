package top.crazyman.boot;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {


    @Bean
    public ApplicationListener applicationListener() {
        return new ProbeApplicationListener();
    }
}
