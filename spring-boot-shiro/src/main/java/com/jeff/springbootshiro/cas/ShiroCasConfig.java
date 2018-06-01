package com.jeff.springbootshiro.cas;

import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.cas.CasSubjectFactory;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by jeff.Wu on 2018/1/17.
 */
@Configuration
public class ShiroCasConfig {

    // cas server地址
    public static final String casServerUrlPrefix = "https://cas.server.com:8443/cas";
    // Cas登录页面地址
    public static final String casLoginUrl = casServerUrlPrefix + "/login";
    // Cas登出页面地址
    public static final String casLogoutUrl = casServerUrlPrefix + "/logout";
    // 当前工程对外提供的服务地址
    public static final String shiroServerUrlPrefix = "http://localhost:9000";
    // casFilter UrlPattern
    public static final String casFilterUrlPattern = "/shiro-cas";
    // 登录地址
    public static final String loginUrl = casLoginUrl + "?service=" + shiroServerUrlPrefix + casFilterUrlPattern;
    // 登出地址
    public static final String logoutUrl = casLogoutUrl + "?service=" + loginUrl;
    // 登录成功地址
    public static final String loginSuccessUrl = "/";
    // 权限认证失败跳转地址
    public static final String unauthorizedUrl = "/error/403.html";

    /**
     * 实例化SecurityManager，该类是shiro的核心类
     *
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroCasRealm());
//      <!-- 用户授权/认证信息Cache, 采用EhCache 缓存 -->
//        securityManager.setCacheManager(getEhCacheManager());
        // 指定 SubjectFactory,如果要实现cas的remember me的功能，需要用到下面这个CasSubjectFactory，并设置到securityManager的subjectFactory中
        securityManager.setSubjectFactory(new CasSubjectFactory());
        return securityManager;
    }

    /**
     * 配置缓存
     * @return
     */
//    @Bean
//    public EhCacheManager getEhCacheManager() {
//        EhCacheManager em = new EhCacheManager();
//        em.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");
//        return em;
//    }

    /**
     * 配置Realm，由于我们使用的是CasRealm，所以已经集成了单点登录的功能
     *
     * @return
     */
    @Bean
    public ShiroCasRealm shiroCasRealm() {
        ShiroCasRealm realm = new ShiroCasRealm();
        // cas登录服务器地址前缀
        realm.setCasServerUrlPrefix(casServerUrlPrefix);
        // 客户端回调地址，登录成功后的跳转地址(自己的服务地址)
        realm.setCasService(shiroServerUrlPrefix + casFilterUrlPattern);
        // 登录成功后的默认角色，此处默认为user角色
        realm.setDefaultRoles("user");
        return realm;
    }


//
//    /**
//     * 注册单点登出的listener
//     * @return
//     */
//    @SuppressWarnings({ "rawtypes", "unchecked" })
//    @Bean
//    @Order(Ordered.HIGHEST_PRECEDENCE)// 优先级需要高于Cas的Filter
//    public ServletListenerRegistrationBean<?> singleSignOutHttpSessionListener(){
//        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean();
//        bean.setListener(new SingleSignOutHttpSessionListener());
//        bean.setEnabled(true);
//        return bean;
//    }

    /**
     * 注册单点登出filter
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean singleSignOutFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setName("singleSignOutFilter");
        bean.setFilter(new SingleSignOutFilter());
        bean.addUrlPatterns("/*");
        bean.setEnabled(true);
        return bean;
    }

    /**
     * 注册DelegatingFilterProxy（Shiro）
     */
    @Bean
    public FilterRegistrationBean delegatingFilterProxy() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));
        //  该值缺省为false,表示生命周期由SpringApplicationContext管理,设置为true则表示由ServletContainer管理
        filterRegistration.addInitParameter("targetFilterLifecycle", "true");
        filterRegistration.setEnabled(true);
        filterRegistration.addUrlPatterns("/*");
        return filterRegistration;
    }


    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 下面两个配置主要用来开启shiro aop注解支持. 使用代理方式;所以需要开启代码支持;
     *
     * @return
     */
    @Bean
//    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }

    /**
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * CAS过滤器
     *
     * @return
     */
    @Bean(name = "casFilter")
    public CasFilter getCasFilter() {
        CasFilter casFilter = new CasFilter();
        casFilter.setName("casFilter");
        casFilter.setEnabled(true);
        casFilter.setFailureUrl(unauthorizedUrl);
        casFilter.setLoginUrl(loginUrl);
        return casFilter;
    }

    /**
     * 使用工厂模式，创建并初始化ShiroFilter
     *
     * @param securityManager
     * @param casFilter
     * @return
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager, CasFilter casFilter) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl(loginUrl);
        /*
         *  登录成功后要跳转的连接，不设置的时候，会默认跳转到前一步的url
         *  建议不要设置这个字段
         */
//        shiroFilterFactoryBean.setSuccessUrl(loginSuccessUrl);

        // 设置无权限访问页面
        shiroFilterFactoryBean.setUnauthorizedUrl(unauthorizedUrl);
        /*
         *  添加casFilter到shiroFilter中，注意，casFilter需要放到shiroFilter的前面，
         *  从而保证程序在进入shiro的login登录之前就会进入单点认证
         */
        Map<String, Filter> filters = new LinkedHashMap<>();
        filters.put("casFilter", casFilter);

        // logout已经被单点登录的logout取代
        // filters.put("logout",logoutFilter());
        shiroFilterFactoryBean.setFilters(filters);

        loadShiroFilterChain(shiroFilterFactoryBean);
        return shiroFilterFactoryBean;
    }

    /**
     * 加载shiroFilter权限控制规则（从数据库读取然后配置）,角色/权限信息由MyShiroCasRealm对象提供doGetAuthorizationInfo实现获取来的
     * 生产中会将这部分规则放到数据库中
     *
     * @param shiroFilterFactoryBean
     */
    private void loadShiroFilterChain(ShiroFilterFactoryBean shiroFilterFactoryBean) {
        /////////////////////// 下面这些规则配置最好配置到配置文件中，注意，此处加入的filter需要保证有序，所以用的LinkedHashMap ///////////////////////
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

        filterChainDefinitionMap.put(casFilterUrlPattern, "casFilter");

        //2.不拦截的请求

        filterChainDefinitionMap.put("/logout", "anon");
        filterChainDefinitionMap.put("/login.html", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/images/**", "anon");
        filterChainDefinitionMap.put("/layui/**", "anon");
        filterChainDefinitionMap.put("/error/**", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        // 此处将logout页面设置为anon，而不是logout，因为logout被单点处理，而不需要再被shiro的logoutFilter进行拦截
        filterChainDefinitionMap.put("/logout", "anon");
        filterChainDefinitionMap.put("/error", "anon");
        //3.拦截的请求（从本地数据库获取或者从casserver获取(webservice,http等远程方式)，看你的角色权限配置在哪里）
        filterChainDefinitionMap.put("/user", "authc"); //需要登录

        //4.登录过的不拦截
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    }


}
