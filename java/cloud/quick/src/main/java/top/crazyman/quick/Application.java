package top.crazyman.quick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 应用入口
 *
 * @author 0z0ne
 * @date 2018/04/19
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.run(args);

    }

}
