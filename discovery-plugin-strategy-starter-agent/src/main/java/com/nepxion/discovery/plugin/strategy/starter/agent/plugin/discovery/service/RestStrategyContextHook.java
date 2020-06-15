package com.nepxion.discovery.plugin.strategy.starter.agent.plugin.discovery.service;


import com.nepxion.discovery.plugin.strategy.service.context.RestStrategyContext;
import com.nepxion.discovery.plugin.strategy.starter.agent.plugin.thread.ThreadLocalHook;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 *
 * @author zifeihan
 * @version 1.0
 */
public class RestStrategyContextHook implements ThreadLocalHook {
    @Override
    public Object create() {
        return RequestContextHolder.getRequestAttributes();
    }

    @Override
    public void before(Object object) {
        if (object instanceof RequestAttributes) {
            RestStrategyContext.getCurrentContext().setRequestAttributes((RequestAttributes) object);
        }
    }

    @Override
    public void after() {
        RestStrategyContext.clearCurrentContext();
    }
}