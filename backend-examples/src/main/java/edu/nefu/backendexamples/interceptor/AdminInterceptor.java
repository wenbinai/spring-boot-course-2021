package edu.nefu.backendexamples.interceptor;

import edu.nefu.backendexamples.common.MyException;
import edu.nefu.backendexamples.common.Role;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (Integer.parseInt(request.getAttribute("role").toString()) < Role.ADMIN) {
            throw new MyException(403, "无权限");
        }
        return true;
    }
}
