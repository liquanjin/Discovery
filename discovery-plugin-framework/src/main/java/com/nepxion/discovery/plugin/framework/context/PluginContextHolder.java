package com.nepxion.discovery.plugin.framework.context;

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
 *
 * 获取上下文中预设的Discovery 信息. 核心是: 获取context 上下文中的
 *
 * 包括: version\region\address. 或包含weight 的等路由策略;
 *
 *
 */
public interface PluginContextHolder {
    String getContext(String name);

    String getContextRouteVersion();

    String getContextRouteRegion();

    String getContextRouteAddress();

    String getContextRouteVersionWeight();

    String getContextRouteRegionWeight();
}