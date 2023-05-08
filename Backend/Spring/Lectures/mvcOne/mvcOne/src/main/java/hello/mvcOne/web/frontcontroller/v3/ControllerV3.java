package hello.mvcOne.web.frontcontroller.v3;

import hello.mvcOne.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);

}
