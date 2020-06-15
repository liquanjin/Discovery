package com.nepxion.discovery.plugin.strategy.adapter;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 *
 * @author Haojun Ren
 * @version 1.0
 */

import com.netflix.loadbalancer.Server;

/**
 * 核心discovery 节点选择器.
 *  决定choose 节点时,最后选择的节点是哪个
 *
 */
public interface DiscoveryEnabledAdapter {
    boolean apply(Server server);
}