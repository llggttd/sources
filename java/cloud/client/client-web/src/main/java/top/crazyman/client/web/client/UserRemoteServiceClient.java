package top.crazyman.client.web.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import top.crazyman.service.api.UserRemoteService;

@FeignClient("common-service")
public interface UserRemoteServiceClient extends UserRemoteService {

}
