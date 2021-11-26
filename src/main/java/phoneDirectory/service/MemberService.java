package phoneDirectory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import phoneDirectory.entity.Member;
import phoneDirectory.repository.MemberRepository;

import java.net.URISyntaxException;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
    }

    public String login(Member member) {
        validateMember(member);
        return member.getId();
    }

    private void validateMember(Member member) {
        Member findMember = memberRepository.findById(member.getId());
        if (findMember == null)
            throw new NullPointerException("존재하지 않는 회원입니다.");
        if (findMember.getPassword().equals(member.getPassword()))
            throw new IllegalArgumentException("올바른 비밀번호가 아닙니다.");
    }

    private void validateDuplicateMember(Member member) {
        Member findMember = memberRepository.findById(member.getId());
        if (findMember != null)
            throw new IllegalStateException("이미 존재하는 회원입니다.");
    }

}
