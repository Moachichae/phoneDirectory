package phoneDirectory.service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import phoneDirectory.entity.Phone;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class RestTemplateResponseService {

    private final Map<String,Phone> phoneMap;

    public RestTemplateResponseService(PhoneService phoneService){
        phoneMap = phoneService.getPhoneMap();
    }

    public String findAllPhoneString(){
        StringBuilder phoneStringBuilder = new StringBuilder();
        for (String key: phoneMap.keySet()){
            phoneStringBuilder.append(phoneMap.get(key).toString());
        }
        return phoneStringBuilder.toString();
    }

    public List<Phone> findAllPhoneList(){
        List<Phone> phones = new ArrayList<>();
        for (String key: phoneMap.keySet()){
            phones.add(phoneMap.get(key));
        }
        return phones;
    }

    public Map<String,Phone> findAllPhoneMap(){
        return phoneMap;
    }


}
