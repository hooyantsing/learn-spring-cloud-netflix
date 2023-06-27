package xyz.hooy.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class AccessPreFilter extends ZuulFilter {

    /**
     * 返回值枚举：
     * pre：前置
     * routing：
     * post：后置
     * error：异常
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 同类型过滤器执行顺序
     * 值越小越先执行
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 启用过滤器
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 全局鉴权
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        log.debug("method: {}, url: {}", request.getMethod(), request.getRequestURL().toString());
        String token = request.getParameter("token");
        if (StringUtils.isNotBlank(token)) {
            log.info("允许访问");
        } else {
            // 请求结束，不再向下传递
            currentContext.setSendZuulResponse(false);
            // 401：权限不足
            currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            log.warn("禁止访问");
        }
        return null;
    }
}
