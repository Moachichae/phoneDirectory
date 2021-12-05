package phoneDirectory.service;

import org.springframework.stereotype.Service;
import phoneDirectory.entity.Phone;
import phoneDirectory.repository.PhoneRepository;

import java.util.Map;

@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;
    private final Map<String, Phone> phoneMap;
    int dataChangeCount = 0;

    private void synchronizeData() {
        this.dataChangeCount++;
        if (this.dataChangeCount == 5) {
            phoneRepository.save(phoneMap);
            this.dataChangeCount = 0;
        }

    }

    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
        this.phoneMap = phoneRepository.findAll();
    }

    public void save(Phone phone) {
        validatePhone(phone);
        phoneMap.put(phone.getNameOrKey(), phone);
        this.synchronizeData();
    }

    public void update(String previousName, Phone updatePhone) {
        validatePhone(previousName, updatePhone);
        Phone remove = phoneMap.remove(previousName);
        this.synchronizeData();
    }

    public void delete(String nameOrKey) {
        Phone remove = phoneMap.remove(nameOrKey);
        if (remove == null)
            throw new NullPointerException("없는 이름입니다.");
        this.synchronizeData();
    }

    public Phone findByName(String nameOrKey) {
        return phoneMap.get(nameOrKey);
    }

    private void validatePhone(String previousName, Phone updatePhone) {
        boolean isChangedName = !previousName.equals(updatePhone.getNameOrKey());
        if (isChangedName)
            validatePhone(updatePhone);
    }

    private void validatePhone(Phone phone) {
        Phone findPhone = phoneMap.get(phone.getNameOrKey());
        if (findPhone != null) {
            throw new IllegalStateException("이미 존재하는 이름입니다.");
        }
    }

    public Map<String, Phone> getPhoneMap() {
        return phoneMap;
    }
}
