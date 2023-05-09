package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 기본 요청
     * 둘다 허용 /hello-basic, /hello-basic/
     * HTTP 메서드 모두 혀옹 GET, HEAD, POST, PUT, PATCH, DELETE
     */

    @RequestMapping("/hello-basic") // /hello-basic URL 호출이 오면 이 메서드가 실행되도록 매핑
    // 대부분의 속성을 배열[]로 제공하므로 다중 설정 가능. {A, B}
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }

    /*
     * 편리한 축약 애노테이션
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     * */
    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mappingGetV2");
        return "ok";
    }

    /*
     *  경로변수 PathVariable 사용
     * 변수명이 같으면 생략 가능
     * @PathVariable("userId") String userId -> @PathVariable userId
     * */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String userId) {
        log.info("mappingPath userId={}", userId);
        return "ok";
    }

    /*
     * PathVariable 사용 다중
     * */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    /*
     * 특정 파라미터 조건 매핑
     * 파라미터로 추가 매핑
     * params="{}",
     * {mode, !mode, mode=debug, mode!=debug, }
     * 혹은
     * params={"mode=debug","data=good"}
     * 주로 사용하진 않는다.
     * */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    /*
     * 특정 헤더로 추가 매핑
     * headers="{}"
     * {mode, !mode, mode=debug, mode!=debug,}
     *
     * -> 파라미터 매핑과 비슷하지만, HTTP 헤더를 사용한다.
     * */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }
    /*
     * 미디어 타입 조건 매핑 - HTTP 요청 Content-Type, consume
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     *
     * Content-Type 헤더로 필터링을 한다.
     * = 핸들러에 consumes 조건을 추가하여 요청을 필터링한다.
     * 어떤 미디어 타입을 허용할 것인지 핸들러에게 명시해준다.
     * 만약 맞지않은 미디어 타입이 들어온다면 HTTP 415을 반환한다.
     * */
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    /*
    * Accept 헤더 기반 Media Type
    * produces = "{}"
    * HTTP 요청의 Accept 헤더를 기반으로 미디어 타입으로 매핑한다.
    * 만약 맞지 않으면 HTTP 406 Not Acceptable을 반환한다.
    *  */

    /*
    * consumes: client -> server에 보내는 데이터 타입을 명시한다. (강제한다.)
    * produces: server -> client에 보내는 데이터 타입을 명시한다. (강제한다.)
    * */
    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }


}
