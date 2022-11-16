package com.is.isgroup.config;

import com.is.isgroup.filter.loginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean registrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new loginFilter());
        filterRegistrationBean.addUrlPatterns("/qwe.html");
        return filterRegistrationBean;
    }
}

