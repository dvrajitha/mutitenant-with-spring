package com.mutitenant.demo.tenant;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class HttpTenantResolver {
    public String resolveTenantId(HttpServletRequest request) {
        return request.getHeader("X-TenantId");
    }
}
