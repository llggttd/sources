package top.crazyman.client.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.crazyman.client.web.client.DateRemoteServiceClient;
import top.crazyman.client.web.client.ItemRemoteServiceClient;
import top.crazyman.client.web.client.UserRemoteServiceClient;
import top.crazyman.service.entity.DateEntity;
import top.crazyman.service.entity.Item;
import top.crazyman.service.entity.User;

@RestController
public class CommonController {

    @Autowired
    private UserRemoteServiceClient userRemoteServiceClient;

    @Autowired
    private ItemRemoteServiceClient itemRemoteServiceClient;

    @Autowired
    private DateRemoteServiceClient dateRemoteServiceClient;

    @RequestMapping("/api/user")
    public User getUser() {
        return userRemoteServiceClient.getUserById(10001L);
    }

    @RequestMapping("/api/item")
    public Item getItem() {
        return itemRemoteServiceClient.getItemById(10001L);
    }

    @RequestMapping("/api/date")
    public DateEntity getDate() {
        return dateRemoteServiceClient.getCurrentDate();
    }
}
