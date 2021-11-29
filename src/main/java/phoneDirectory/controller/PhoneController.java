package phoneDirectory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import phoneDirectory.entity.Phone;
import phoneDirectory.service.PhoneService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class PhoneController {

    private final PhoneService phoneService;

    @GetMapping(value = "/phoneList")
    public String list(Model model) {
        Map<String, Phone> phoneMap = phoneService.getPhoneMap();
        model.addAttribute("phoneMap", phoneMap);
        return "/phones/phoneList";
    }

    @PostMapping(value = "/phones/new")
    public String create(HttpServletRequest httpServletRequest, Phone phone) {
        HttpSession httpSession = httpServletRequest.getSession();
        String memberId = (String) httpSession.getAttribute("memberId");
        if (memberId != null)
            phoneService.save(phone);

        return "redirect:/";
    }

    @GetMapping(value = "/phones/{nameOrKey}/edit")
    public String editForm(@PathVariable String nameOrKey, Model model) {
        Phone phone = phoneService.findByName(nameOrKey);
        model.addAttribute("phone", phone);
        return "/phones/phoneEditForm";
    }

    @PostMapping(value = "/phones/{nameOrKey}/edit")
    public String edit(@PathVariable String nameOrKey, Phone phone) {
        phoneService.update(nameOrKey, phone);
        return "redirect:/";
    }

    @GetMapping(value = "/phones/{nameOrKey}/delete")
    public String delete(@PathVariable String nameOrKey) {
        phoneService.delete(nameOrKey);
        return "redirect:/";
    }

    @GetMapping(value = "/phones/{nameOrKey}", produces = "application/text; charset=UTF-8")
    @ResponseBody
    public String findByName(@PathVariable String nameOrKey) {
        Phone phone = phoneService.findByName(nameOrKey);
        return phone.toString();
    }


}
