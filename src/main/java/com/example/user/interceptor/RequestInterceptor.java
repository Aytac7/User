package com.example.user.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception{
        try{
            System.out.println("1-preHandle(): Before sending request to the Controller");
            System.out.println("Methode Type " + request.getMethod());
            System.out.println("Request URL: " + request.getRequestURI());
        }

        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public  void postHandle (HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
        try {
            System.out.println("2 - postHandle() : After the Controller serves the request (before returning back response to the client)");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{
        try {
            System.out.println("3 - afterCompletion() : After the request and Response is completed");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
