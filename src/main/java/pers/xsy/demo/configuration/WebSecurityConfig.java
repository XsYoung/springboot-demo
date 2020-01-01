package pers.xsy.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> MyAuthenticationDetailsAuthenticationDetailsSource;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/captcha").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .authenticationDetailsSource(MyAuthenticationDetailsAuthenticationDetailsSource)
                .loginPage("/loginPage")
                .loginProcessingUrl("/auth/form")
                .permitAll()
                .and()
            .rememberMe()
                .userDetailsService(userDetailsService)
                .key("xsy")
                .and()
            .csrf()
                .disable()
            .sessionManagement()
                .maximumSessions(1);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/**/vendors/**","/**/fonts/**","/**/img/**","/**/js/**","/**/css/**");
    }
}
