package phoneDirectory.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import phoneDirectory.entity.Member;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = new MemberRepository();

    @Test
    void save() throws URISyntaxException {
        //given
        Member member = new Member("abcd", "1234");

        //when
        memberRepository.save(member);

        //then
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }
}