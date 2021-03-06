package app.configuration;

import app.init.SecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                DataServiceConfig.class,
                SecurityConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                WebConfig.class,
                RestClientConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{
                "/rest/*"
        };
    }
}