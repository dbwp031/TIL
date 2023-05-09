package hello.springmvc.basic;

import lombok.Data;

@Data // -> @Getter, @Setter, @ToStringm @EqualsAndHashCode, @RequiredARgsConstructor를 자동으로 적용
public class HelloData {
    private String username;
    private int age;
}
