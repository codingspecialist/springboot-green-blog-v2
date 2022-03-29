package site.metacoding.blogv2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.service.PostService;

@RequiredArgsConstructor
@Controller
public class PostController {
    private final PostService postService;

    // 페이지를 줘
    // /s 붙었으니까 자동으로 인터셉터가 인증 체크함. (완)
    @GetMapping("/s/post/writeForm")
    public String writeForm() {
        return "post/writeForm";
    }

    @GetMapping({ "/", "/post" })
    public String home() {
        return "post/list";
    }
}
