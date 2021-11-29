package phoneDirectory.repository;

import org.junit.jupiter.api.Test;
import phoneDirectory.entity.Phone;

import java.util.Map;

class PhoneRepositoryTest {

    PhoneRepositoryImpl phoneRepository = new PhoneRepositoryImpl();

    @Test
    void save() {
        //given

        //when

        //then
    }

    @Test
    void findAll(){
        //given

        //when
        Map<String,Phone> phoneDirectory = phoneRepository.findAll();

        //then
        phoneDirectory.forEach((key, value) -> System.out.print(value.toString()));

    }

}