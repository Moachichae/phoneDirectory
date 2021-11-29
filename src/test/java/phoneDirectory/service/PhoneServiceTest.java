package phoneDirectory.service;

import org.junit.jupiter.api.Test;
import phoneDirectory.entity.Phone;
import phoneDirectory.repository.PhoneRepository;
import phoneDirectory.repository.PhoneRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

class PhoneServiceTest {

    PhoneService phoneService = new PhoneService(new PhoneRepositoryImpl());

    @Test
    void save() {
        //given
        Phone phone = new Phone("채승호","970201","0106426432");

        //when
        phoneService.save(phone);

        //then
    }

    @Test
    void update() {
        //given
        Phone phone = new Phone("채승호","970201","01064026432");
        String name = "채승호";
        //when
        phoneService.update(name,phone);

        //then

    }

    @Test
    void delete() {
        //given
        String name = "채승호";
        //when
        phoneService.delete(name);

        //then
    }
}