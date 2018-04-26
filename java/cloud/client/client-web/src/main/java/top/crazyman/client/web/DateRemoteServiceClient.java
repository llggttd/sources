package top.crazyman.client.web;

import org.springframework.cloud.netflix.feign.FeignClient;
import top.crazyman.service.api.DateRemoteService;
import top.crazyman.service.entity.DateEntity;

/**
 * Description:
 *
 * @author <a href="liuguotao@zuozh.com">Guotao.Liu</a>
 * @date Create on 2018/4/26
 * @since version 1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
@FeignClient("date-remote-service")
public class DateRemoteServiceClient implements DateRemoteService {

    @Override
    public DateEntity getCurrentDate() {
        return null;
    }

}
