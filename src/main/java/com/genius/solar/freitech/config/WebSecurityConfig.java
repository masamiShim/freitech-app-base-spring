package com.genius.solar.freitech.config;

import com.genius.solar.freitech.common.SessionExpireDetectingLoginUrlAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationProvider authProvider;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    public void configure(WebSecurity web) {
        //@formatter: off
        web.ignoring().antMatchers(
                "/images/**",
                "/css/**",
                "/js/**");
        //@formatter: on
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().xssProtection().and().frameOptions().and()
                .contentTypeOptions().and().cacheControl();
        //@formatter: off
        http.authorizeRequests()
                    .antMatchers("/",
                            "/login",
                            "/login-error",
                            "/logout",
                            "/signin",
                            "/images/**",
                            "/js/**",
                            "/css/**")
                    .permitAll()
                    .anyRequest().authenticated();
        http.csrf().disable()
                    .formLogin()
                        .loginPage("/login")
                        .loginProcessingUrl("/auth")
                        .defaultSuccessUrl("/login_success")
                        .failureUrl("/login?error")
                        .usernameParameter("userId")
                        .passwordParameter("password")
                        .permitAll()
                    .and()
                        .rememberMe()
                        .tokenValiditySeconds(86400)
                    .and()
                        .logout()
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID", "remember-me")
                        .permitAll()
                    .and()
                        .exceptionHandling()
                        .authenticationEntryPoint(authenticationEntryPoint());
        //@formatter: on
    }

    @Bean
    AuthenticationEntryPoint authenticationEntryPoint() {
        return new SessionExpireDetectingLoginUrlAuthenticationEntryPoint("/login");
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //@formatter: off
        auth.authenticationProvider(authProvider);
        //@formatter: on
    }
}
