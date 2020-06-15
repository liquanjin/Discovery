package com.nepxion.discovery.plugin.strategy.rule;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 *
 * @author Haojun Ren
 * @version 1.0
 */

import com.nepxion.discovery.plugin.framework.adapter.PluginAdapter;
import com.nepxion.discovery.plugin.strategy.adapter.DiscoveryEnabledAdapter;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 核心
 * 粘合 ZoneAvoidancePredicate 和 discovery 的节点选择的器
 *
 */
public class DiscoveryEnabledZoneAvoidancePredicate extends ZoneAvoidancePredicate {
    /**
     * 未使用
     */
    protected PluginAdapter pluginAdapter;
    protected DiscoveryEnabledAdapter discoveryEnabledAdapter;
    private static final Logger LOG = LoggerFactory.getLogger(DiscoveryEnabledZoneAvoidancePredicate.class);

    public DiscoveryEnabledZoneAvoidancePredicate(IRule rule, IClientConfig clientConfig) {
        super(rule, clientConfig);
    }

    public DiscoveryEnabledZoneAvoidancePredicate(LoadBalancerStats lbStats, IClientConfig clientConfig) {
        super(lbStats, clientConfig);
    }

    @Override
    public boolean apply(PredicateKey input) {
        LOG.info("used DiscoveryEnabledZoneAvoidancePredicate apply");
        boolean enabled = super.apply(input);
        if (!enabled) {
            return false;
        }

        return apply(input.getServer());
    }

    protected boolean apply(Server server) {
        if (discoveryEnabledAdapter == null) {
            return true;
        }

        return discoveryEnabledAdapter.apply(server);
    }

    public void setPluginAdapter(PluginAdapter pluginAdapter) {
        this.pluginAdapter = pluginAdapter;
    }

    public void setDiscoveryEnabledAdapter(DiscoveryEnabledAdapter discoveryEnabledAdapter) {
        this.discoveryEnabledAdapter = discoveryEnabledAdapter;
    }
}