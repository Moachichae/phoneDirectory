package phoneDirectory.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import phoneDirectory.entity.Member;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
class JwtServiceImplTest {
//   private JwtServiceImpl jwtService = JwtServiceImpl.getInstance();
    private final JwtServiceImpl jwtService = new JwtServiceImpl();

    @Test
    void jwtTest() throws UnsupportedEncodingException {
        //given
        Member member = new Member("kimchi", "123");
        //when
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsb2dpblRva2VuIiwiZ" +
                "XhwIjoxNjM5MzgwNDkxLCJtZW1iZXJJZCI6InJoZGlkZGw0NDMyIn0.niUnI4JHDqB76-ophy5rJGAOLWeKABXoFa9DbT0LxpQ";
        System.out.println(token);

        Map<String, Object> memberValue = jwtService.verifyJWT(token);
        //then
        System.out.println(memberValue.get("memberId"));
    }

}