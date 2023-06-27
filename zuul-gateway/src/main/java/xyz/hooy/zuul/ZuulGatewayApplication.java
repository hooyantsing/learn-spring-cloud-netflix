package xyz.hooy.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy // 开启 Zuul
@EnableEurekaClient
@EnableHystrixDashboard
// 开启 HystrixDashboard dashboard访问：http://127.0.0.1:19000/hystrix 监控流访问：http://127.0.0.1:19000/actuator/hystrix.stream
@SpringBootApplication
public class ZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
    }

}
