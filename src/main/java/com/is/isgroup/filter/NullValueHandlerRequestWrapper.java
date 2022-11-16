package com.is.isgroup.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;

public class NullValueHandlerRequestWrapper extends HttpServletRequestWrapper {
    private Map<String, String[]> parameterMap;

    public NullValueHandlerRequestWrapper(HttpServletRequest request) {
        super(request);
    }
    @Override
    public String getParameter(String name) {
        String[] result = parameterMap.get(name);
        return result[0];
    }
    public void setParameterMap(Map<String,String[]> parameterMap){
        this.parameterMap = parameterMap;
    }
    @Override
    public Map<String, String[]> getParameterMap() {
        return super.getParameterMap();
    }

    @Override
    public Enumeration<String> getParameterNames() {
        Vector<String> vector = new Vector<String>(parameterMap.keySet());
        return vector.elements();
    }

    @Override
    public String[] getParameterValues(String name) {
        return super.getParameterValues(name);
    }
}
