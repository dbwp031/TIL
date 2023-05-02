# Object Oriented Programming - 객체 지향 프로그래밍
## SOLID - 객체 지향 설계 5원칙
<details>
  <summary>Single Responsibility Principal - 단일 책임 원칙</summary>

<strong>하나의 클래스는 하나의 책임만 져야 한다.</strong>

모든 클래스는 하나의 책임만 가지며, 클래스는 그 책임을 완전히 캡슐화해야 한다

SRP를 지키지 않은 `MemberService`는 아래와 같은 책임들을 가진다.
* `MemoryMemberRepository`라는 구현 객체 생성 및 연결, 실행

SRP를 지킨다면 아래의 기능만 있어야 한다.
* 실행하는 책임
</details>  