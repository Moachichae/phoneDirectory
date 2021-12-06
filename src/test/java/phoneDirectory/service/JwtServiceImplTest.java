package phoneDirectory.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import phoneDirectory.entity.Member;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JwtServiceImplTest {
//   private JwtServiceImpl jwtService = JwtServiceImpl.getInstance();
    private final JwtServiceImpl jwtService = new JwtServiceImpl();

    @Test
    void jwtTest() throws UnsupportedEncodingException {
        //given
        Member member = new Member("kimchi", "123");
        //when
        String token = jwtService.createToken(member.getId());
        System.out.println(token);

        Map<String, Object> memberValue = jwtService.verifyJWT(token);
        //then
        System.out.println(memberValue.get("memberId"));
    }

}