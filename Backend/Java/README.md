# Java

<details>
<summary>static</summary>
static 키워드를 통해, 정적 변수 및 정적 메소드를 사용할 수 있다.

정적 변수와 정적 메소드는 프로그램 시작 시점에 메모리에 한번 할당되어, 프로그램이 종료되는 시점에 메모리에서 해제된다.

일반적으로 new 키워드로 생성된 객체들은 heap영역에 생성되어, Garvage Collector (GC)에 관리를 받는다. 반대로, static 키워드로 static 영역에 생성된 메모리는 GC의 관리를 받지 않는다.
(이때 class들도 static 영역에 생성된다.)
</details>
