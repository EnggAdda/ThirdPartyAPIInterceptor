package org.example.thirdpartyapiinterceptor.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CustomHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // Pre-process the request before the controller method is invoked
        System.out.println("preHandle: request details" );
        System.out.println("request method "  +request.getMethod());
        System.out.println("request headers " +request.getHeaderNames());

        System.out.println("preHandle: response details" );
        System.out.println("response headers "  +response.getHeaderNames());
        System.out.println("response headers " +response.getStatus());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        // Post-process the response before it is sent to the client
        System.out.println("postHandle: request details" );
        System.out.println("request method "  +request.getMethod());
        System.out.println("request headers " +request.getHeaderNames());

        System.out.println("postHandle: response details" );
        System.out.println("response headers "  +response.getHeaderNames());
        System.out.println("response headers " +response.getStatus());
        System.out.println("modelView" +modelAndView);

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // Handle errors after the request has been completed
        if (ex != null) {
            // Log the error or perform custom error handling
            System.err.println("Error occurred: " + ex.getMessage());
        }
    }
}

