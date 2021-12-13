package phoneDirectory.service;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class JwtServiceImpl {
    private final String key = "abcdefghijklmnop";

    //토큰 생성
    public String createToken(String memberId) {
        //claimMap 부분 설정
        Map<String, Object> claimMap = new HashMap<>();
        claimMap.put("memberId", memberId);

        return Jwts.builder()
                .setHeader(this.getHeaders()) // Headers 설정
                .setClaims(claimMap) // Claims 설정
                .setSubject("loginToken") // 토큰 용도
                .setExpiration(this.getExtTime()) // 토큰 만료 시간 설정
                .signWith(SignatureAlgorithm.HS256, key.getBytes()) // HS256과 Key로 Sign
                .compact(); // 토큰 생성
    }

    //토큰 검증
    public Map<String, Object> verifyJWT(String jwt) {
        Map<String, Object> claimMap = null;
        try {
            claimMap = Jwts.parser()
                    .setSigningKey(key.getBytes(StandardCharsets.UTF_8)) // Set Key
                    .parseClaimsJws(jwt) // 파싱 및 검증, 실패 시 에러
                    .getBody();
        } catch (ExpiredJwtException e) { // 토큰이 만료되었을 경우
            log.error("토큰 만료");
        } catch (Exception e) { // 그외 에러났을 경우
            log.error("검증 실패");
        }
        log.info("검증완료: " + claimMap);
        return claimMap;
    }

    //Header 설정
    private Map<String, Object> getHeaders() {
        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "JWT");
        headers.put("alg", "HS256");
        return headers;
    }

    //만료 시간 설정
    private Date getExtTime() {
        long expiredTime = 1000 * 60L * 2;// 토큰 유효 시간  2시간
        Date ext = new Date(); // 토큰 만료 시간
        ext.setTime(ext.getTime() + expiredTime);
        return ext;
    }

}
