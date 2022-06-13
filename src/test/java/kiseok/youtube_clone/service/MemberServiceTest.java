package kiseok.youtube_clone.service;

import kiseok.youtube_clone.domain.Member;
import kiseok.youtube_clone.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception{
        //given
        Member member = new Member("member1");
        //when
        memberService.signUp(member);
        //then
        Member one = memberRepository.findOne(member.getId());
        assertThat(member).isEqualTo(one);
    }

    @Test()
    public void 회원가입_중복() throws Exception{
        //given
        Member member = new Member("member1");
        memberService.signUp(member);
        //when
        Member memberDup = new Member("member1");
        //then
        assertThrows(IllegalStateException.class, ()-> memberService.signUp(memberDup));
    }

    @Test
    public void 로그인() throws Exception{
        //given
        // memberService.clear();
        Member member = new Member("member1");
        memberService.signUp(member);
        //when

        Member member1 = memberService.signIn("member1");
        //then
        assertThat(member1).isEqualTo(member);
    }

}