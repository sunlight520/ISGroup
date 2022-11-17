package com.is.isgroup.config;

import com.is.isgroup.filter.loginFilter;
import com.is.isgroup.filter.loginFilterTest;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean registrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new loginFilterTest());
        filterRegistrationBean.addUrlPatterns("/web/main.html");
        return filterRegistrationBean;
    }
}

