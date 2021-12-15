package phoneDirectory.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import phoneDirectory.entity.Member;
import phoneDirectory.entity.Phone;
import phoneDirectory.service.MemberService;
import phoneDirectory.service.RestTemplateResponseService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@Slf4j
@RestController
public class RestTemplateResponseController {

    private final RestTemplateResponseService restTemplateResponseService;
    private final MemberService memberService;

    @GetMapping("/phoneString")
    public String[] getPhoneString() {
        log.info(restTemplateResponseService.findAllPhoneString());
        return new String[]{restTemplateResponseService.findAllPhoneString()};
    }

    @GetMapping("/phoneList")
    public List<Phone> getPhoneList(){
       return restTemplateResponseService.findAllPhoneList();
    }

    @GetMapping("/phoneMap")
    public Map<String,Phone> getPhoneMap(){
        return restTemplateResponseService.findAllPhoneMap();
    }

    @PostMapping("/phoneString")
    public String[] postPhoneString(@RequestBody Member member) {
        memberService.login(member);
        return new String[]{restTemplateResponseService.findAllPhoneString()};
    }

    @PostMapping("/phoneList")
    public List<Phone> postPhoneList(@RequestBody Member member){
        memberService.login(member);
        return restTemplateResponseService.findAllPhoneList();
    }

    @PostMapping("/phoneMap")
    public Map<String,Phone> postPhoneMap(@RequestBody Member member){
        memberService.login(member);
        return restTemplateResponseService.findAllPhoneMap();
    }

}
