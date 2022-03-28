package site.metacoding.blogv2.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import site.metacoding.blogv2.web.api.dto.ResponseDto;

// 모든 예외를 낚아채는 친구
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseDto<String> error1(RuntimeException e) {
        return new ResponseDto<String>(-1, "실패", e.getMessage());
    }

}