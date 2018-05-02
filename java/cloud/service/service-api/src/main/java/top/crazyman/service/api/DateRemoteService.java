package top.crazyman.service.api;

import org.springframework.web.bind.annotation.RequestMapping;
import top.crazyman.service.entity.DateEntity;

/**
 * Description:
 *
 * @author <a href="liuguotao@zuozh.com">Guotao.Liu</a>
 * @date Create on 2018/4/26
 * @since version 1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
@RequestMapping("/common-service")
public interface DateRemoteService {

    @RequestMapping("/data")
    DateEntity getCurrentDate();
}
