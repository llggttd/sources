package top.crazyman.service.web.controller;

import org.springframework.web.bind.annotation.RestController;
import top.crazyman.service.api.ItemRemoteService;
import top.crazyman.service.entity.Item;

@RestController
public class ItemController implements ItemRemoteService {

    @Override
    public Item getItemById(Long id) {
        Item item = new Item();
        item.setId(id);
        item.setName("name:" + id);
        return item;
    }
}
