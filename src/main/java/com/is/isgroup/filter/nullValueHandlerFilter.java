package com.is.isgroup.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class nullValueHandlerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Map<String,String[]> parameterMap = new HashMap<>(request.getParameterMap());
        Set<Map.Entry<String,String[]>> entrySet = parameterMap.entrySet();
        Iterator<Map.Entry<String,String[]>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String[]> entry = iterator.next();
            if (entry.getValue()!=null){
                for (int i=0;i<entry.getValue().length;i++){
                    if ("".equals(entry.getValue()[i])){
                        iterator.remove();
                    }
                }
            }
        }
        NullValueHandlerRequestWrapper wrapper = new NullValueHandlerRequestWrapper((HttpServletRequest)request);
        wrapper.setParameterMap(parameterMap);
        chain.doFilter(wrapper,response);
    }
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
