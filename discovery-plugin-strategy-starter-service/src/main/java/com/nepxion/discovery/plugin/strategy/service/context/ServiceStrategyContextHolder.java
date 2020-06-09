package com.nepxion.discovery.plugin.strategy.service.context;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 *
 * @author Haojun Ren
 * @author Fan Yang
 * @version 1.0
 */

import com.nepxion.discovery.common.util.JsonUtil;
import com.nepxion.discovery.plugin.strategy.context.AbstractStrategyContextHolder;
import com.nepxion.discovery.plugin.strategy.service.filter.ServiceStrategyRouteFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sun.rmi.runtime.Log;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class ServiceStrategyContextHolder extends AbstractStrategyContextHolder {
    private static final Logger LOG = LoggerFactory.getLogger(ServiceStrategyContextHolder.class);

    @Autowired
    private ServiceStrategyRouteFilter serviceStrategyRouteFilter;

    public ServletRequestAttributes getRestAttributes() {
        RequestAttributes requestAttributes = RestStrategyContext.getCurrentContext().getRequestAttributes();
        if (requestAttributes == null) {
            LOG.info(" RestStrategyContext.getCurrentContext() requestAttributes is null. value:{}",requestAttributes);
            requestAttributes = RequestContextHolder.getRequestAttributes();
        }

        return (ServletRequestAttributes) requestAttributes;
    }

    public Map<String, Object> getRpcAttributes() {
        return RpcStrategyContext.getCurrentContext().getAttributes();
    }

    @Override
    public String getHeader(String name) {
        ServletRequestAttributes attributes = getRestAttributes();
        if (attributes == null) {
            LOG.warn("The ServletRequestAttributes object is lost for thread switched probably");
            return null;
        }

        return attributes.getRequest().getHeader(name);
    }

    @Override
    public String getRouteVersion() {
        return serviceStrategyRouteFilter.getRouteVersion();
    }

    @Override
    public String getRouteRegion() {
        return serviceStrategyRouteFilter.getRouteRegion();
    }

    @Override
    public String getRouteAddress() {
        return serviceStrategyRouteFilter.getRouteAddress();
    }

    @Override
    public String getRouteVersionWeight() {
        return serviceStrategyRouteFilter.getRouteVersionWeight();
    }

    @Override
    public String getRouteRegionWeight() {
        return serviceStrategyRouteFilter.getRouteRegionWeight();
    }
}