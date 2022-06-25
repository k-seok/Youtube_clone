package kiseok.youtube_clone.service;

import kiseok.youtube_clone.domain.Member;
import kiseok.youtube_clone.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;


    public Long signUp(Member member) {
        validateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateMember(Member member) {
        List<Member> byName = memberRepository.findByName(member.getName());
        if (!byName.isEmpty()) {
            throw new IllegalStateException("Duplicated username. Please retry with another name");
        }
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findMember(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    public Member signIn(String name) {
        List<Member> byName = memberRepository.findByName(name);
        if (byName.isEmpty()) {
            throw new IllegalStateException("No such username. Please check your username");
        }
        return byName.get(0);
    }
}
