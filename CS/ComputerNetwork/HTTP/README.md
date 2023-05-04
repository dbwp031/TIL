# HTTP for Developers
김영한님의 [모든 개발자를 위한 HTTP 웹 기본 지식](https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC)을 보며 정리한 글

* 목적
  * 강의를 듣고 이해했는지 확인하고자 함
  * 이후에 HTTP 관련 내용이 궁금할 때 참고하고자 함
* 진행 방법
  * 각 섹션에 대한 학습이 완료된 후, 정리
* 진행 기간
  * Start Date: 2023.05.04
  * Dead Line: 2023.05.05
  * End Date: 
* 목차
  * [섹션 1. 인터넷 네트워크 (IP, TCP&UDP, PORT, DNS)](#섹션-1-인터넷-네트워크)

## 섹션 1. 인터넷 네트워크

인터넷 프로토콜 스택은 4계층으로 이루어져 있다.
* 애플리케이션 계층 -> HTTP, FTP
* 전송 계층 -> TCP, UDP
* 인터넷 계층 -> IP
* 네트워크 인터페이스 계층

<details>
<summary>IP</summary>

### Internet Protocol, 인터넷이 통하는 네트워크에서 정보를 통신할 때 사용하는 규약
* 지정한 IP 주소에 데이터를 전달
* 패킷이라는 통신 단위로 데이터를 전달
  * IP 패킷에는 출발지 IP 및 목적지 IP의 정보를 포함하고 있다. 
* IP 프로토콜는 3가지의 한계를 가지고 있다. 이 한계를 해결해주는 것이 TCP
  * 한계 1: 비연결성
    * 패킷을 받을 대상이 없거나 받을 수 없는 상태여도 패킷이 전송된다.
  * 한계 2: 비신뢰성
    * 중간에 패킷이 사라지거나 패킷의 순서가 꼬여도 이에 대한 고려가 되지 않는다.
  * 한계 3 프로그램 구분:
    * 같은 IP를 사용하는 서버에서 통신하는 애플리케이션이 둘 이상일 때의 상황이 고려되지 않는다.

```
* 패킷
  * 패킷이란, 네트워크에서 데이터 전달에 형식화된 블록이다.
  * 제어정보 + 사용자 데이터로 구성된다. 
  * 더 자세한 내용은 Computer Network 정리 시에 작성
```

</details>

<details>
 <summary>TCP & UDP</summary>
 
 ### Transition Control Protocol
 * TCP 세그먼트
   * 출발지 PORT, 목적지 PORT, 전송 제어, 순서, 검증 정보 ... 등등 IP에서의 한계를 보완하는 정보들이 추가되어 있다.
 * TCP 특징
   * 연결지향 - 3 way handshake (가상 연결)
     1. 클라 -> 서버 (sync 날림)
     2. 서버 -> 클라 (ack + sync 날림)
     3. 클라 -> 서버 (ack 날림)
       * sync: 접속 요청
       * ack : 요청 수락
   * 데이터 전달 보증
      * 데이터가 전달을 받으면 전달 받았다는 정보를 다시 전달
   * 순서 보장
      * 패킷 순서에 대한 정보를 가지고 있어서, 순서대로 들어오지 않을 시에 재전송하도록 함.
 
 ### User Datagram Protocol
*  IP와 거의 같다. + PORT + 체크섬(메세지 제대로 왔는지 검증하는 데이터) 정도만 추가
* 애플리케이션에서 추가 작업이 필요
</details>


<details>
 <summary>PORT</summary>
 ### PORT
 TCP / IP 패킷 = IP 패킷 + TCP 세그먼트, 출발지 및 도착지에 대한 포트정보는 TCP 세그먼트에 들어있다.
 
 같은 IP 주소에서 여러 애플리케이션을 사용할 때, 프로세스를 구분하기 위해서 사용된다.
 
 `IP주소 -> 주소, Port -> 아파트 호수` 정도로 비유를 들 수 있다.
</details>


<details>
 <summary>DNS</summary>
 ### Domain Name System
 * IP는 기억하기 어렵고, 변경될 가능성이 있다.
 * 이를 해결하기 위해 DNS 사용.
 * DNS 서버에는 `도메인 명 - IP 주소` 정보가 있어 DNS 서버에서 도메인 명으로 도메인 IP 주소를 알 수 있다.
</details>
