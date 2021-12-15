package phoneDirectory.controller;

import com.sun.org.apache.regexp.internal.RE;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@ControllerAdvice
@RestController
@Slf4j
public class ExceptionController {

   @ExceptionHandler(value = ExpiredJwtException.class)
    public ResponseEntity<String> tokenExpirationException() {
        log.error("토큰 만료");
        return new ResponseEntity<String>("토큰 만료", HttpStatus.BAD_REQUEST);
   }
}
