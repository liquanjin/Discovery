package com.nepxion.discovery.sentinel.starter.apollo.configuration;

import com.nepxion.discovery.plugin.framework.adapter.PluginAdapter;
import com.nepxion.discovery.plugin.strategy.constant.StrategyConstant;
import com.nepxion.discovery.plugin.strategy.sentinel.constant.SentinelConstant;
import com.nepxion.discovery.plugin.strategy.sentinel.loader.RuleLoader;
import com.nepxion.discovery.sentinel.starter.apollo.constant.ApolloSentinelConstant;
import com.nepxion.discovery.sentinel.starter.apollo.loader.ApolloRuleLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Weihua
 * @since 1.0.0
 */
@Configuration
@ConditionalOnProperty(value = StrategyConstant.SPRING_APPLICATION_STRATEGY_SENTINEL_ENABLED)
public class SentinelApolloAutoConfiguration {

  /** Apollo 特有的命名空间 */
  @Value("${" + ApolloSentinelConstant.APOLLO_NAMESPACE_KEY + ":" + ApolloSentinelConstant.DEFAULT_APOLLO_NAMESPACE + "}")
  private String namespace;

  @Autowired
  private PluginAdapter pluginAdapter;

  /* 以下参数已在SentinelStrategyAutoConfiguration类中初始化，再次初始化是因为以下文件中的json将作为默认规则 */

  /** 流控规则文件路径 */
  @Value("${" + SentinelConstant.SENTINEL_FLOW_PATH + ":file:" + SentinelConstant.SENTINEL_FLOW_KEY + ".json}")
  private String flowPath;
  /** 降级规则文件路径 */
  @Value("${" + SentinelConstant.SENTINEL_SYSTEM_PATH + ":file:" + SentinelConstant.SENTINEL_SYSTEM_KEY + ".json}")
  private String degradePath;
  /** 授权规则文件路径 */
  @Value("${" + SentinelConstant.SENTINEL_AUTH_PATH + ":file:" + SentinelConstant.SENTINEL_AUTH_KEY + ".json}")
  private String authorityPath;
  /** 系统规则文件路径 */
  @Value("${" + SentinelConstant.SENTINEL_DEGRADE_PATH + ":file:" + SentinelConstant.SENTINEL_DEGRADE_KEY + ".json}")
  private String systemPath;
  /** 热点参数流控规则文件路径 */
  @Value("${" + SentinelConstant.SENTINEL_PARAM_PATH + ":file:" + SentinelConstant.SENTINEL_PARAM_KEY + ".json}")
  private String paramPath;


  @Bean
  public RuleLoader ruleLoader(){
    return new ApolloRuleLoader(namespace, pluginAdapter, flowPath, systemPath, authorityPath, degradePath, paramPath);
  }

}
