package com.nepxion.discovery.plugin.strategy.service.filter;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 * @author Haojun Ren
 * @version 1.0
 */

/**
 *  服务策略路由过滤器,面向的是 AbstractStrategyInterceptor 中的参数获取
 *
 */
public interface ServiceStrategyRouteFilter {
    String getRouteVersion();

    String getRouteRegion();

    String getRouteAddress();

    String getRouteVersionWeight();

    String getRouteRegionWeight();
}