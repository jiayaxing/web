package com.jiayaxing.web.config.shiro;

import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;

public class MySessionManager extends DefaultWebSessionManager { 
  
    public MySessionManager() {  
        super();  
    }  
  
    @Override  
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {  
        String id = WebUtils.toHttp(request).getHeader("Authorization");  
        //如果请求头中有 Authorization 则其值为sessionId  
        if (!StringUtils.isEmpty(id)) {  
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, "Stateless request");  
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);  
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);  
            return id;  
        } else {  
            //否则按默认规则从cookie取sessionId  
            return super.getSessionId(request, response);  
        }  
    }  
}
