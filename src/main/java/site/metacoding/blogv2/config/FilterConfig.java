package site.metacoding.blogv2.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import site.metacoding.blogv2.config.filter.MyFilter1;
import site.metacoding.blogv2.config.filter.MyFilter2;

// Controller, RestController, Repository, Service, Component, Configuration

//@Configuration
public class FilterConfig {

    public FilterConfig() {
        System.out.println("나 메모리(IoC컨테이너)에 뜸 FilterConfig");
    }

    @Bean // IoC 컨테이너 필터 설정파일 등록
    public FilterRegistrationBean<?> filter1() {
        FilterRegistrationBean<MyFilter1> bean = new FilterRegistrationBean<>(new MyFilter1());
        bean.addUrlPatterns("/*");
        bean.setOrder(1); // 낮은 번호의 필터가 가장 먼저 실행됨.
        return bean;
    }

    @Bean // IoC 컨테이너 필터 설정파일 등록
    public FilterRegistrationBean<?> filter2() {
        FilterRegistrationBean<MyFilter2> bean = new FilterRegistrationBean<>(new MyFilter2());
        bean.addUrlPatterns("/*");
        bean.setOrder(2); // 낮은 번호의 필터가 가장 먼저 실행됨.
        return bean;
    }
}
