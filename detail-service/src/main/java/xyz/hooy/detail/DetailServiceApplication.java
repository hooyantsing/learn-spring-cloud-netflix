package xyz.hooy.detail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

// @EnableHystrix // 开启 Hystrix，@EnableCircuitBreaker 注解已废弃
@EnableFeignClients // 开启 OpenFeign
@EnableEurekaClient // 开启 Eureka 客户端，可省略。@EnableDiscoveryClient 由 spring-cloud 提供，开启任意注册中心客户端
@SpringBootApplication
public class DetailServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DetailServiceApplication.class, args);
    }
}
