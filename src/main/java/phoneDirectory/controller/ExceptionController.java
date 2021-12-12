package phoneDirectory.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@ControllerAdvice
@RestController
@Slf4j
public class ExceptionController {

//    @ExceptionHandler(value = Exception.class)
    public String BadRequestException() {
        // service 에서 구현한 로그인,연락처 중복발생시 예외처리 main 으로 화면 돌림
        log.error("에러 발생");
        return "<script>"
                + "alert(\"error\");"
                + "location.href=\"/\";"
                + "</script>";
    }
}
