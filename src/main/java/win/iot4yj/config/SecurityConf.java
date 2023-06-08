package win.iot4yj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * security 配置
 *
 * @author YJ
 * @date 2023/6/6
 **/
@Configuration
public class SecurityConf extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            // 指定登陆页面
            .loginPage("/login.html")
            .loginProcessingUrl("/doLogin")
            .defaultSuccessUrl("/index")
            .failureUrl("/login.html")
            .usernameParameter("name")
            .passwordParameter("pass")
            .permitAll()
            .and()
            .csrf().disable();
    }

    /**
     * 对相关静态资源放行
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("joy")
            .password("walp1314")
            .roles("admin");
    }
}
