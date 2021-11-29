package phoneDirectory.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import phoneDirectory.entity.Member;
import phoneDirectory.service.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String creatForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(Member member, BindingResult result) {
        memberService.join(member);
        if (result.hasErrors())
            return "members/createMemberForm";
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "members/loginMemberForm";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, Member member) {
        String memberId = memberService.login(member);

        HttpSession session = request.getSession();
        session.setAttribute("memberId",member.getId());
        return "redirect:/";
    }


}
