package com.zecan.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @ClassName MyLogGateWayFilter
 * @Description TODO
 * @date 2022/5/7 16:31
 * @Version 1.0
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("**************come in MyLogGateWayFilter：" + new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname == null ) {
            log.info("*******用户名为null，非法用户！！");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return exchange.getResponse().setComplete();
    }

    @Override
    public int getOrder() {
        //返回值是过滤器的优先级，越小优先级越高（最小-2147483648，最大2147483648）
        return 0;
    }
}
