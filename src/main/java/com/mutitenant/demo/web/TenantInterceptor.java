package com.mutitenant.demo.web;

import com.mutitenant.demo.tenant.HttpTenantResolver;
import com.mutitenant.demo.tenant.TenantContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TenantInterceptor implements HandlerInterceptor {
    private final HttpTenantResolver httpTenantResolver;

    public TenantInterceptor(HttpTenantResolver httpTenantResolver) {
        this.httpTenantResolver = httpTenantResolver;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        TenantContext.setTenantId(httpTenantResolver.resolveTenantId(request));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        TenantContext.clear();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        TenantContext.clear();
    }
}
