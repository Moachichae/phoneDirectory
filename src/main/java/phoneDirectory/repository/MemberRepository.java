package phoneDirectory.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import phoneDirectory.entity.Member;

import java.io.*;
import java.net.URISyntaxException;
import java.util.StringTokenizer;

@Repository
public class MemberRepository {

   private final String PATH = "C:\\Study\\phoneDirectory\\src\\main\\resources\\files\\members.txt";

    public void save(Member member) {
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

    public Member findById(String id) {


        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH), 16* 1024);

            String str;
            StringTokenizer st;
            while ((str = br.readLine()) != null) {
                st = new StringTokenizer(str, ",");

                String fileId = st.nextToken();
                String filePw = st.nextToken();

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
