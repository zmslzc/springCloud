package com.zecan.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName GateWayConfigure
 * @Description TODO
 * @date 2022/5/7 10:39
 * @Version 1.0
 */
@Configuration
public class GateWayConfigure {


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_angenin",  //id
                r -> r.path("/guonei")  //访问 http://localhost:9527/guonei
                        .uri("http://news.baidu.com/guonei"));  //就会转发到 http://news.baidu.com/guonei

        routes.route("path_route_angenin2",  //id
                r -> r.path("/guoji")  //访问 http://localhost:9527/guoji
                        .uri("http://news.baidu.com/guoji"));  //就会转发到 http://news.baidu.com/guonji

        return routes.build();
    }

}
