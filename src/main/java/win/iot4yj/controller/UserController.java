package win.iot4yj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author YJ
 * @date 2023/6/6
 **/
@RestController
public class UserController {

    @GetMapping("/index")
    public String index() {
        return "login success";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello spring security";
    }
}
