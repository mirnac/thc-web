package com.treshermanas.thcweb.exception;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionMappingResolver extends SimpleMappingExceptionResolver {

    @Override
    public String buildLogMessage(Exception e, HttpServletRequest req) {
        return "MVC exception: " + e.getLocalizedMessage();
    }

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request,
                                              HttpServletResponse resp, Object handler, Exception ex) {
        // Call super method to get the ModelAndView
        ModelAndView mav = super.doResolveException(request, resp, handler, ex);

        // Make the full URL available to the view - note ModelAndView uses
        // addObject() but Model uses addAttribute(). They work the same.
        mav.addObject("url", request.getRequestURL());
        return mav;
    }

}
