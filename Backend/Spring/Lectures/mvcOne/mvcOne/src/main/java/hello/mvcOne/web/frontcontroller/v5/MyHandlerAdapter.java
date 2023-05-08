package hello.mvcOne.web.frontcontroller.v5;

import hello.mvcOne.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

    boolean supports(Object handler); // handler는 컨트롤러를 말한다.
                                      // 어댑터가 해당 컨트롤러를 처리할 수 있을지 판단하는 메서드다.
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
    // 어뎁터는 실제 컨트롤러를 호출하고, 그 결과로 ModelView를 반환해야 한다.
    // 실제 컨트롤러가 반환하지 못하면, 어댑터가 생성해서라도 반환해야 한다.
    // 이전에는 프론트 컨트롤러가 실제 컨트롤러를 호출했지만 이젠 이 어댑터를 통해서 실제 컨트롤러가 호출된다.
}
