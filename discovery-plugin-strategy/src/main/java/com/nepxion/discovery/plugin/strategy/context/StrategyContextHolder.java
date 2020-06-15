package com.nepxion.discovery.plugin.strategy.context;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 *
 * @author Haojun Ren
 * @version 1.0
 */

/**
 * 获取 configure 中配置 的Discovery 信息
 *
 * 包括: version\region\address.\versionWeight\regionWeight 的路由策略;
 *
 */
public interface StrategyContextHolder {
    String getHeader(String name);

    String getRouteVersion();

    String getRouteRegion();

    String getRouteAddress();

    String getRouteVersionWeight();

    String getRouteRegionWeight();
}