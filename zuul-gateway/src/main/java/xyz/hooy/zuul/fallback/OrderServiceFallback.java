package xyz.hooy.zuul.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 网关熔断，只会处理超时异常（TimeoutException）
 */
@Component
public class OrderServiceFallback implements FallbackProvider {

    /**
     * 为哪个服务配置降级
     */
    @Override
    public String getRoute() {
        return "order-service";
    }

    /**
     * 降级后向前端返回什么
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {

            /**
             * 错误枚举
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }

            /**
             * 错误码
             */
            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.INTERNAL_SERVER_ERROR.value();
            }

            /**
             * 错误信息
             */
            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            /**
             * 响应体
             */
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("\"message\":\"订单服务不可用，稍后再试\"".getBytes(StandardCharsets.UTF_8));
            }

            /**
             * 响应头
             */
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
                return httpHeaders;
            }
        };
    }
}
