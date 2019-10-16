package com.example.modulefeign;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * 开启hystrixDashboard
 */
@EnableHystrixDashboard
/**
 * 开启Feign的功能
 */
@EnableFeignClients
@SpringBootApplication
public class ModuleFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleFeignApplication.class, args);
    }

    /**
     * Spring Cloud Finchley 版本以前访问路径是/hystrix.stream，如果是Finchley的话就需要加入上面的配置。
     * 因为spring Boot 2.0.x以后的actuator只暴露了info和health2个端点
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
