package com.nepxion.discovery.plugin.strategy.adapter;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 * @author Haojun Ren
 * @version 1.0
 */

import com.netflix.loadbalancer.Server;

/**
 * 节点选择 核心.
 * 单节点 选择比较器
 */
public interface DiscoveryEnabledStrategy {
    boolean apply(Server server);
}