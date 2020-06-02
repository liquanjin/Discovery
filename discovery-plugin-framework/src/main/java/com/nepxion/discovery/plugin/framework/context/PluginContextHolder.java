package com.nepxion.discovery.plugin.framework.context;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 * @author Haojun Ren
 * @version 1.0
 */

/**
 *  核心接口
 * plugin 上下文 接口
 */
public interface PluginContextHolder {
    String getContext(String name);

    String getContextRouteVersion();

    String getContextRouteRegion();

    String getContextRouteAddress();

    String getContextRouteVersionWeight();

    String getContextRouteRegionWeight();
}