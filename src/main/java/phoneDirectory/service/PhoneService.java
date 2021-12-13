package phoneDirectory.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import phoneDirectory.entity.Phone;
import phoneDirectory.repository.PhoneRepository;

import java.util.Map;

@Service
@Slf4j
public class PhoneService {

    private final PhoneRepository phoneRepository;
    private final Map<String, Phone> phoneMap;
    int dataChangeCount = 0;

    private void synchronizeData() { //맵 값이 5번 이상 바뀔때마다 파일에 저장
        this.dataChangeCount++;
        if (this.dataChangeCount == 5) {
            phoneRepository.save(phoneMap);
            this.dataChangeCount = 0;
        }

    }

    public PhoneService(PhoneRepository phoneRepository) { //빈 생성시 데이터 로딩
        this.phoneRepository = phoneRepository;
        this.phoneMap = phoneRepository.findAll();
    }

    public String save(Phone phone) {
        validateCreate(phone);
        phoneMap.put(phone.getNameOrKey(), phone);
        log.info(phone.getNameOrKey() + " map에 저장");
        this.synchronizeData();
        return phone.getNameOrKey();
    }

    public void update(String previousName, Phone updatePhone) {
        validateUpdate(previousName, updatePhone);
        phoneMap.remove(previousName);
        phoneMap.put(updatePhone.getNameOrKey(),updatePhone);
        log.info(previousName + "->" + updatePhone.getNameOrKey() + " map에 update");
        this.synchronizeData();
    }

    public void delete(String nameOrKey) {
        Phone remove = phoneMap.remove(nameOrKey);
        if (remove == null)
            throw new NullPointerException("없는 이름입니다.");
        log.info(nameOrKey + "삭제");
        this.synchronizeData();
    }

    public Phone findByName(String nameOrKey) {
        return phoneMap.get(nameOrKey);
    }

    private void validateUpdate(String previousName, Phone updatePhone) {//업데이트시 데이터 검증
        boolean isChangedName = previousName.equals(updatePhone.getNameOrKey()); //true = 이름을 변경하지 않음
        Phone findPhone = phoneMap.get(updatePhone.getNameOrKey());
        if (!isChangedName && findPhone != null) {// 이름 변경 시 변경할 이름이 이미 존재한다면.
            throw new IllegalStateException("이미 존재하는 이름입니다.");
        }
    }

    private void validateCreate(Phone phone) { //데이터 삽입시 검증
        Phone findPhone = phoneMap.get(phone.getNameOrKey());
        if (findPhone != null) {
            throw new IllegalStateException("이미 존재하는 이름입니다.");
        }
    }

    public Map<String, Phone> getPhoneMap() {
        return phoneMap;
    }
}
