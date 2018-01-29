package org.superbiz.spring;

import com.opensymphony.module.sitemesh.filter.PageFilter;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.superbiz.struts")
@EntityScan("org.superbiz.struts")
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean dispatchFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        FilterDispatcher dispatcherFilter = new FilterDispatcher();
        filterRegistrationBean.setFilter(dispatcherFilter);
        filterRegistrationBean.setName("dispatcherFilter");
      //  filterRegistrationBean.addInitParameter(FilterDispatcher.APP_FACT_PARAM,
        //        SpringWebApplicationFactory.class.getName());
        filterRegistrationBean.addInitParameter("actionPackages", "com.lq");
        filterRegistrationBean.addUrlPatterns("/*");
        //filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);

        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean cleanupFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        ActionContextCleanUp actionContextCleanup = new ActionContextCleanUp();
        filterRegistrationBean.setFilter(actionContextCleanup);
        filterRegistrationBean.setName("struts-cleanup");
        filterRegistrationBean.addUrlPatterns("/*");
        //  filterRegistrationBean.addInitParameter(FilterDispatcher.APP_FACT_PARAM,
        //        SpringWebApplicationFactory.class.getName());
        //filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);

        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean sitemeshFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        PageFilter pageFilter = new PageFilter();
        filterRegistrationBean.setFilter(pageFilter);
        filterRegistrationBean.setName("sitemesh");
        filterRegistrationBean.addUrlPatterns("/*");
        //  filterRegistrationBean.addInitParameter(FilterDispatcher.APP_FACT_PARAM,
        //        SpringWebApplicationFactory.class.getName());
        //filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);

        return filterRegistrationBean;
    }

}
