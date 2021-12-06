package phoneDirectory.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import phoneDirectory.entity.Member;
import phoneDirectory.service.JwtServiceImpl;
import phoneDirectory.service.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


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

    @PostMapping("/login")
    public String login(HttpServletRequest request, Member member, RedirectAttributes redirectAttr) {
        String memberId = memberService.login(member);
        String token = jwtService.createToken(memberId);
        log.info("토큰생성 : " + token);
        redirectAttr.addFlashAttribute("token",token);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }
}
