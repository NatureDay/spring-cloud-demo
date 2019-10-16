package com.example.moduleribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaltError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://module-client/hi?name=" + name, String.class);
    }

    public String defaltError(String name) {
        return "hi," + name + ",sorry,error!";
    }

}
