package win.iot4yj.config;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 * 自定义登陆失败处理类
 *
 * @author YJ
 * @date 2023/6/12
 **/
public class MyAuthenticationFailHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
        AuthenticationException exception) throws IOException, ServletException {
        String message = exception.getMessage();
        System.out.println("-----error msg: " + message);

        request.getRequestDispatcher("/login.html").forward(request, response);

    }
}
