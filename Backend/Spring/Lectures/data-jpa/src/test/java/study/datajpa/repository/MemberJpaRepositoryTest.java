package study.datajpa.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import study.datajpa.entity.Member;
import study.datajpa.repository.MemberJpaRepository;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional //
@Rollback(false) // test시에 transactional쓰면, rollback default:true
public class MemberJpaRepositoryTest {

    @Autowired
    MemberJpaRepository memberJpaRepository;

    @Test
    public void testMember() {
        Member member = new Member("memberA");
        Member savedMember = memberJpaRepository.save(member); //등록

        Member findMember = memberJpaRepository.find(savedMember.getId()); //찾기
        assertThat(findMember.getId()).isEqualTo(member.getId());
//        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(member).isEqualTo(savedMember);
        assertThat(member).isEqualTo((findMember));
        assertThat(savedMember).isEqualTo(findMember);
    }
}
