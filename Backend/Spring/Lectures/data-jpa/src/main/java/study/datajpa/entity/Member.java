package study.datajpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString(of = {"id", "username", "age"}) // 객체를 찍을때 출력이 바로 되도록
                                          // 가급적 연관관계 (team)은 추가하지 마라
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id") //편의상 PK는 table_변수
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY) // Lazy로 해야 개발이 쉽다.
    @JoinColumn(name="team_id") // -> foreign key
    private Team team;

    public Member(String username) {
        this.username = username;
    }

    public Member(String member, int age, Team team) {
        this.username = member;
        this.age = age;
        if (team != null) {
            changeTeam(team);
        }
    }

    public void changeTeam(Team team){
        this.team = team;
        team.getMembers().add(this);
    }



//    public Member(String username, int age) {
//        this(username, age, null);
//    }

//    public Member(String username, int age, Team team) {
//        this.username = username;
//        this.age = age;
//        if (team != null) {
//            changeTeam(team);
//        }
//    }
//
//    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }
}


