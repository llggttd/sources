package top.crazyman.service.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.crazyman.service.entity.Item;

/**
 * Description:
 *
 * @author <a href="liuguotao@zuozh.com">Guotao.Liu</a>
 * @date Create on 2018/4/24
 * @since version 1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
@RequestMapping("/common-service")
public interface ItemRemoteService {

    @RequestMapping("/item")
    Item getItemById(@RequestParam("id") Long id);

}
