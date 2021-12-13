package phoneDirectory.controller;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


//@ControllerAdvice
//@RestController
//@Slf4j
//public class ExceptionController {
//
//   @ExceptionHandler(value = NullPointerException.class)
//    public String tokenExpirationException() {
//        log.error("에러 발생");
//        return "<script>"
//                + "alert(\"로그인하세요\");"
//                + " localStorage.clear();"
//                + "</script>";
//    }
//}
