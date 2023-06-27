package xyz.hooy.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AdviceErrorFilter extends ZuulFilter {

    /**
     * 注意：需要关闭 zuul 提供的默认 error 过滤器，自定义过滤器才可生效
     */
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 全局异常处理
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        Throwable throwable = currentContext.getThrowable();
        log.debug("throwable: {}", throwable.getMessage());
        currentContext.setResponseStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return null;
    }
}
