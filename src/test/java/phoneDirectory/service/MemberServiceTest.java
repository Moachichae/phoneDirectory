package phoneDirectory.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import phoneDirectory.entity.Member;
import phoneDirectory.repository.MemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService = new MemberService(new MemberRepository());

    @Test
    void join() {
        //given
        Member member = new Member("abc","1234");

        //when
        Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member));

        //then

    }
}