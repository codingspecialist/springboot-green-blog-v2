package site.metacoding.blogv2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestViewController {
    // 모든 페이지 잘 작동하는지 확인 후 푸시 - 2. 컨트롤러 페이지 작동 테스트

    @GetMapping("/test/post/detail")
    public String test1() {
        return "post/detail";
    }

    @GetMapping("/test/post/list")
    public String test2() {
        return "post/list";
    }

    @GetMapping("/test/post/updateForm")
    public String test3() {
        return "post/updateForm";
    }

    @GetMapping("/test/post/writeForm")
    public String test4() {
        return "post/writeForm";
    }

    @GetMapping("/test/user/detail")
    public String test5() {
        return "user/detail";
    }

    @GetMapping("/test/user/joinForm")
    public String test6() {
        return "user/joinForm";
    }

    @GetMapping("/test/user/loginForm")
    public String test7() {
        return "user/loginForm";
    }

    @GetMapping("/test/user/updateForm")
    public String test8() {
        return "user/updateForm";
    }
}
