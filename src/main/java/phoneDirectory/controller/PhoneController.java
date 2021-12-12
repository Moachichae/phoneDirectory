package phoneDirectory.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import phoneDirectory.entity.Phone;
import phoneDirectory.service.JwtServiceImpl;
import phoneDirectory.service.PhoneService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PhoneController {

    private final PhoneService phoneService;
    private final JwtServiceImpl jwtService;

    @GetMapping(value = "/phones/new")
    public String createForm() {
        return "/phones/createPhoneForm";
    }

    @GetMapping(value = "/phoneList")
    public String list(Model model) {
        Map<String, Phone> phoneMap = phoneService.getPhoneMap();
        model.addAttribute("phoneMap", phoneMap);
        return "/phones/phoneList";
    }

    @PostMapping(value = "/phones/new")
    @ResponseBody
    public String create(@RequestBody PhoneForm phoneDTO) {
//        if (isToken(httpServletRequest)){ //토큰이 존재하면
//            phoneService.save(phone);
//        }
        return "redirect:/";
    }

    @GetMapping(value = "/phones/{nameOrKey}/edit")
    public String editForm(@PathVariable String nameOrKey, Model model) {
        Phone phone = phoneService.findByName(nameOrKey);
        model.addAttribute("phone", phone);
        return "/phones/phoneEditForm";
    }

    @PostMapping(value = "/phones/{nameOrKey}/edit")
    public String edit(@PathVariable String nameOrKey, Phone phone, HttpServletRequest httpServletRequest) {
        if (isToken(httpServletRequest)){
            phoneService.update(nameOrKey, phone);
        }
        return "redirect:/";
    }

    @GetMapping(value = "/phones/{nameOrKey}/delete")
    public String delete(@PathVariable String nameOrKey, HttpServletRequest httpServletRequest) {
        if (isToken(httpServletRequest)){
            phoneService.delete(nameOrKey);
        }
        return "redirect:/";
    }

    @GetMapping(value = "/phones/{nameOrKey}", produces = "application/text; charset=UTF-8")
    @ResponseBody
    public String findByName(@PathVariable String nameOrKey) {
        Phone phone = phoneService.findByName(nameOrKey);
        return phone.toString();
    }

    private boolean isToken(HttpServletRequest httpServletRequest){
        if (jwtService.verifyJWT(getToken(httpServletRequest)) == null){
            // 토큰이 없으면 session 초기화 후 초기화면으로 보냄
            log.info("토큰 만료");
            httpServletRequest.getSession().invalidate();
            return false;
        }
        return true;
    }

    private String getToken(HttpServletRequest httpServletRequest) {
        HttpSession httpSession = httpServletRequest.getSession();
        return (String) httpSession.getAttribute("token");
    }

}
