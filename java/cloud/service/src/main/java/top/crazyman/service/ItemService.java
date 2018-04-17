package top.crazyman.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemService {

    @RequestMapping("item")
    public String getItem(Long id) {
        return "This is item - " + id;
    }
}
