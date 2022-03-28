package site.metacoding.blogv2.config.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import site.metacoding.blogv2.domain.user.User;

public class SessionIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("preHandle 호출됨");

        HttpSession session = request.getSession();

        User principal = (User) session.getAttribute("principal");

        if (principal == null) {
            throw new RuntimeException("인증되지 않았습니다.");
        } else {
            return true;
        }

    }

}
