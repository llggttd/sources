package top.crazyman.client.web.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import top.crazyman.service.api.ItemRemoteService;

@FeignClient("common-service")
public interface ItemRemoteServiceClient extends ItemRemoteService {

}
