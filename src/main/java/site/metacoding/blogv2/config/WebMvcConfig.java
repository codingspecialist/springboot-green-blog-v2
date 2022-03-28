package site.metacoding.blogv2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import site.metacoding.blogv2.config.intercepter.SessionIntercepter;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionIntercepter())
                .addPathPatterns("/s/**"); // *, **
    }

    /*
     * @Override
     * public void addInterceptors(InterceptorRegistry registry) {
     * registry.addInterceptor(new SessionIntercepter())
     * .addPathPatterns("/s/*")
     * .addPathPatterns("/user/*")
     * .excludePathPatterns("/s/post/*");
     * }
     */

}
