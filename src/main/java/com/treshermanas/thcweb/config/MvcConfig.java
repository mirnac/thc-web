package com.treshermanas.thcweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("index");
        registry.addViewController("").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/error").setViewName("thc_error");


        registry.addViewController("/payments/report/go").setViewName("payments/payments_report");
        registry.addViewController("/invoices/unpaid/report/go").setViewName("invoices/unpaid_report");
        registry.addViewController("/pedidos/tablero").setViewName("productos/pedidos");
    }
}

