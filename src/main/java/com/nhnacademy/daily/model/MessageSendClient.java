package com.nhnacademy.daily.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "messageSendClient", url = "https://hook.dooray.com/services")
public interface MessageSendClient {

    @PostMapping("/3204376758577275363/4071284119244117501/RibHlHtpSlCOQ1Kesn_0KQ")
    String sendMessage(@RequestBody MessagePayload messagePayload);
}
