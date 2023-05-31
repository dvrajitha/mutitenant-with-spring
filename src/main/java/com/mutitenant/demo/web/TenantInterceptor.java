package com.mutitenant.demo.web;

import com.mutitenant.demo.tenant.HttpTenantResolver;
import com.mutitenant.demo.tenant.TenantContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TenantInterceptor implements HandlerInterceptor {
    private final static Logger LOGGER = LoggerFactory.getLogger(TenantInterceptor.class);
    private final HttpTenantResolver httpTenantResolver;

    public TenantInterceptor(HttpTenantResolver httpTenantResolver) {
        this.httpTenantResolver = httpTenantResolver;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String tenant = httpTenantResolver.resolveTenantId(request);
        TenantContext.setTenantId(tenant);
        LOGGER.info("===================tenantName:{}============================",tenant);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOGGER.info("===============================================2");
        TenantContext.clear();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOGGER.info("===============================================3");
        TenantContext.clear();
    }
}
