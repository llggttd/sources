package top.crazyman.client;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/test/1")
    public String getCurrentDate() {
        JsonNode object = restTemplate.getForObject("http://localhost:8201/date/current", JsonNode.class);
        return object.get("date").asText();
    }
}
