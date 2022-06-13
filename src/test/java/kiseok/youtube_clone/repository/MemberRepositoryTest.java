package kiseok.youtube_clone.repository;

import kiseok.youtube_clone.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Rollback(value = false)
    void 멤버_저장() {
        //given
        Member member = new Member("member1");

        //when
        memberRepository.save(member);

        //then
        Member findMember = memberRepository.findOne(member.getId());

        assertThat(findMember).isEqualTo(member);
    }

    @Test
    public void 없는_멤버_검색() throws Exception{
        //given
        //memberRepository.clear()
        //when
        Member one = memberRepository.findOne(2L);
        //then
        assertThat(one).isNull();
    }

    @Test
    public void 멤버_이름으로_찾기() throws Exception{
        //given
        Member member = new Member("name");
        memberRepository.save(member);
        //when
        List<Member> byName = memberRepository.findByName(member.getName());
        //then
        assertThat(byName.get(0).getName()).isEqualTo(member.getName());
    }
}