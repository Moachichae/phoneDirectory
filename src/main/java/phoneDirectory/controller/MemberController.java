package phoneDirectory.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import phoneDirectory.entity.Member;
import phoneDirectory.service.JwtServiceImpl;
import phoneDirectory.service.MemberService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


@Controller
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final JwtServiceImpl jwtService;

    @GetMapping("/members/new")
    public String creatForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(Member member, BindingResult result) {
        memberService.join(member);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "members/loginMemberForm";
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public ResponseEntity<String> login(@RequestBody Member member) {
        String memberId = memberService.login(member);
        String token = jwtService.createToken(memberId);

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

}
