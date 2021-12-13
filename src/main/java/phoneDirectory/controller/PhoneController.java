package phoneDirectory.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // 연락처 생성
    @PostMapping(value = "/phones/new")
    @ResponseBody
    public ResponseEntity<String> create(@RequestBody Phone phone) {
        String nameOrKey = phoneService.save(phone);
        return new ResponseEntity<String>(nameOrKey, HttpStatus.OK);
    }

    @GetMapping(value = "/phones/{nameOrKey}/edit")
    public String editForm(@PathVariable String nameOrKey, Model model) {
        Phone phone = phoneService.findByName(nameOrKey);
        model.addAttribute("phone", phone);
        return "/phones/phoneEditForm";
    }

    //연락처 업데이트
    @PostMapping(value = "/phones/{previousNameOrKey}/edit")
    @ResponseBody
    public ResponseEntity<String> edit(@PathVariable String previousNameOrKey, @RequestBody Phone phone) {
        phoneService.update(previousNameOrKey, phone);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    //연락처 삭제
    @PostMapping(value = "/phones/delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestBody Phone phone) {
        phoneService.delete(phone.getNameOrKey());
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    //이름으로 연락처 찾기
    @GetMapping(value = "/phones/{nameOrKey}", produces = "application/text; charset=UTF-8")
    @ResponseBody
    public String findByName(@PathVariable String nameOrKey) {
        Phone phone = phoneService.findByName(nameOrKey);
        return phone.toString();
    }

    @ResponseBody
    @PostMapping(value = "/token")
    public ResponseEntity<String> validateToken(@RequestBody TokenDTO token){
        if (jwtService.verifyJWT(token.getToken()) == null)
            return new ResponseEntity<String>("false", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<String>("Success",HttpStatus.OK);
    }

}
