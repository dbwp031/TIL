package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // Restful 웹 서비스의 컨트롤러 @Controller + @ResponseBody (뷰를 사용하지 않고, HTTP 메시지 바디에 직접 데이터를 입력)
public class LogTestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String LogTest() {
        String name = "Spring";

         log.trace("trace log={}", name);
         log.debug("debug log={}", name);
         log.info(" info log={}", name);
         log.warn(" warn log={}", name);
         log.error("error log={}", name);

        // 위의 코드를 아래와 같이 사용할 수 있다. -> 의미없는 더하기 연산이 추가되니, 위 처럼 구현하자.
//        log.trace("trace log=" + name);
//        log.debug("debug log=" + name);
//        log.info(" info log=" + name);
//        log.warn(" warn log=" + name);
//        log.error("error log=" + name);

        return "ok";
    }
}
