package site.metacoding.blogv2.web.api;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.service.UserService;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;
}
