package top.crazyman.client.web.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import top.crazyman.service.api.DateRemoteService;

/**
 * Description:
 *
 * @author <a href="liuguotao@zuozh.com">Guotao.Liu</a>
 * @date Create on 2018/4/26
 * @since version 1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
@FeignClient("common-service")
public interface DateRemoteServiceClient extends DateRemoteService {

}
