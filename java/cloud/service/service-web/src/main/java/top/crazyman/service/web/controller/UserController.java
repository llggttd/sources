package top.crazyman.service.web.controller;

import org.springframework.web.bind.annotation.RestController;
import top.crazyman.service.api.UserRemoteService;
import top.crazyman.service.entity.User;

@RestController
public class UserController implements UserRemoteService {

    @Override
    public User getUserById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("user:" + id);
        user.setPassword("pass:" + id);
        return user;
    }

}
