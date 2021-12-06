package phoneDirectory.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import phoneDirectory.entity.Phone;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Repository
@Slf4j
public class PhoneRepositoryImpl implements PhoneRepository {

    private final String PATH = "C:\\Study\\phoneDirectory\\src\\main\\resources\\files\\phoneDirectory.txt";

    @Override
    public void save(Map<String,Phone> phoneDirectory) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(PATH, false));

            for (String key : phoneDirectory.keySet()){
                Phone phone = phoneDirectory.get(key);
                bw.write(phone.toString());
            }

            bw.flush();
            bw.close();
            log.info("phoneMap 파일저장");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, Phone> findAll() {
        Map<String, Phone> phoneDirectory = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH), 16 * 1024);
            String str;

            while ((str = br.readLine()) != null) {
                Phone phone = createPhoneBySplit(str);
                phoneDirectory.put(phone.getNameOrKey(), phone);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("phoneMap 파일읽기");
        return phoneDirectory;
    }

    private Phone createPhoneBySplit(String str) {
        String[] split = str.split(",");
        String name = split[0];
         String birth = split[1];
        String number = split[2];
        return new Phone(name, birth, number);
    }


}
