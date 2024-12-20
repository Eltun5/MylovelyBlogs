package com.Simple_Blog.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInit implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //app
        var appContext
                = new AnnotationConfigWebApplicationContext();
        appContext.register(AppConfig.class);

        //web
        var webContext
                = new AnnotationConfigWebApplicationContext();
        webContext.register(WebConfig.class);

        var dispatcherServlet
                = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(webContext));
        dispatcherServlet.addMapping("/");
        dispatcherServlet.setLoadOnStartup(1);

    }
}
