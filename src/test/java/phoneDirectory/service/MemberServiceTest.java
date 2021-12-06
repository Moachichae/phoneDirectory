package phoneDirectory.service;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import phoneDirectory.entity.Member;
import phoneDirectory.repository.MemberRepository;

@Slf4j
class MemberServiceTest {
    MemberService memberService = new MemberService(new MemberRepository());

    @Test
    void join() {
        //given
        Member member = new Member("abc","1234");
        log.info("test");
        //when
        Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member));

        //then

    }
}