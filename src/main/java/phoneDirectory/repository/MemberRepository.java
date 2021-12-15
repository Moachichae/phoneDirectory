package phoneDirectory.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import phoneDirectory.entity.Member;

import java.io.*;
import java.util.StringTokenizer;

@Repository
@Slf4j
public class MemberRepository {

   private final String PATH = "C:\\Study\\phoneDirectory\\src\\main\\resources\\files\\members.txt";

    public void save(Member member) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(PATH, true));
            bw.write(member.toString());
            bw.flush();
            log.info(member.getId() + "저장");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Member findById(String id) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH), 16* 1024);

            String str;
            while ((str = br.readLine()) != null) {
                String[] split = str.split(",");

                String fileId = split[0];
                String filePw = split[1];

                if (id.equals(fileId))
                    return new Member(fileId, filePw);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

}
