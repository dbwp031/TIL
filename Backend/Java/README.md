# Java

<details>
<summary>static</summary>
static 키워드를 통해, 정적 변수 및 정적 메소드를 사용할 수 있다.

정적 변수와 정적 메소드는 프로그램 시작 시점에 메모리에 한번 할당되어, 프로그램이 종료되는 시점에 메모리에서 해제된다.

일반적으로 new 키워드로 생성된 객체들은 heap영역에 생성되어, Garvage Collector (GC)에 관리를 받는다. 반대로, static 키워드로 static 영역에 생성된 메모리는 GC의 관리를 받지 않는다.
(이때 class들도 static 영역에 생성된다.)
</details>

<details>
<summary>Access Modifier</summary>
접근 제한자 혹은 접근 지정자

클래스, 인터페이스 혹은 멤버에 대한 접근을 제한하기 위해 사용되는 키워드이다.

public, protected, private이 있고, 아무 제한자가 사용되지 않았을 때 사용되는 default 제한자가 존재한다.

* public [클래스 / 멤버]: 외부 클래스가 자유롭게 사용 가능하다.
* protected [멤버]: 같은 패키지 (클래스들의 모음) 혹은 자식 클래스에서 사용 가능하다. (부모 클래스는 사용하지 못한다는 의미)
* private [멤버]: 외부에서 사용할 수 없다.
* default [클래스 / 멤버]: 같은 패키지에 소속된 클래스만 사용할 수 있다.

Java는 객체지향언어로, private 멤버 선언을 지향해야 한다.


</details>
