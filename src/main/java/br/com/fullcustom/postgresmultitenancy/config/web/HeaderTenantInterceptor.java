package br.com.fullcustom.postgresmultitenancy.config.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class HeaderTenantInterceptor extends HandlerInterceptorAdapter {

    public static final String TENANT_HEADER = "X-tenant";

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        ThreadTenantStorage.clear();
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {        
        ThreadTenantStorage.setTenantId(request.getHeader(TENANT_HEADER));        
        return super.preHandle(request, response, handler);
    }    
}