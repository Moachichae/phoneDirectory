package phoneDirectory.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import phoneDirectory.entity.Member;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = new MemberRepository();

    @Test
    void save() {
        //given
        Member member = new Member("아니 ㅗ애 안돼~~~~~ ", "1234");

        //when
        memberRepository.save(member);

        //then
    }

    @Test
    void findById() throws IOException {
        //given
        String id = "abcdd";

        //when
        Member member = memberRepository.findById(id);

        //then
        Assertions.assertEquals(member.getId(),id);
    }
}