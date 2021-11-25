package phoneDirectory.repository;

import org.springframework.stereotype.Repository;
import phoneDirectory.entity.Member;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Repository
public class MemberRepository {

    private final String PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\files\\members.txt";

    public void save(Member member) throws URISyntaxException {
        String id = member.getId();
        String pw = member.getPassword();
        String txt = id + "," + pw + "\n";

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(PATH, true));
            bw.write(txt);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

   


}
