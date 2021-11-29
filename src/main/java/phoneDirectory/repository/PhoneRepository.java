package phoneDirectory.repository;

import phoneDirectory.entity.Phone;

import java.util.Map;

public interface PhoneRepository {
    void save(Map<String,Phone> phoneDirectory);

    Map<String,Phone> findAll();


}
