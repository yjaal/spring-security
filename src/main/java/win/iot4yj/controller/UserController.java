package win.iot4yj.controller;

import com.google.gson.Gson;
import java.security.Principal;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping("/user")
    public void userInfoQry() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        System.out.println("name: " + name);

        Gson gson = new Gson();
        System.out.println("authorities: " + gson.toJson(authorities));
    }

    @GetMapping("/authentication")
    public void authentication(Authentication authentication) {
        Gson gson = new Gson();
        System.out.println("authentication: " + gson.toJson(authentication));
    }

    @GetMapping("/principal")
    public void principal(Principal principal) {
        Gson gson = new Gson();
        System.out.println("principal: " + gson.toJson(principal));
    }

    @GetMapping("/info")
    public void info(HttpServletRequest req) {
        String remoteUser = req.getRemoteUser();
        Authentication authentication = (Authentication) req.getUserPrincipal();
        System.out.println("remoteUser: " + remoteUser);
        Gson gson = new Gson();
        System.out.println("authentication: " + gson.toJson(authentication));
    }
}
