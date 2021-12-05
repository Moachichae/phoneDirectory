package phoneDirectory.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@ControllerAdvice
@RestController
public class ExceptionController {

    @ExceptionHandler(value = Exception.class)
    public String BadRequestException() {
        return "<script>"
                + "alert(\"error\");"
                + "location.href=\"/\";"
                + "</script>";
    }
}
