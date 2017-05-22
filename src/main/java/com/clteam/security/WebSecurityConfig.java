package com.clteam.security;

import com.clteam.security.constant.SecurityConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * Created by Khanh Nguyen on 4/5/2017.
 */

@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailService;

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//    @Bean
//    public AuthenticationFilter authenticationFilterFilter() throws Exception {
//        AuthenticationFilter authFilter = new AuthenticationFilter();
//        authFilter.setAuthenticationManager(authenticationManager());
//        return authFilter;
//    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.addFilterBefore(authenticationFilterFilter(), UsernamePasswordAuthenticationFilter.class);
        // By defaut, csrf enabled
        // If you want disable csrf, use
        // http.csrf().disable();
        http
                 // If only using https
                 //.requiresChannel().anyRequest().requiresSecure()
                // If only using http
                // .requiresChannel().anyRequest().requiresInsecure()

                //Mixing http and https
                .requiresChannel()
                .antMatchers("/perform_login")
                .requiresSecure()
        .and()
                .requiresChannel()
                .anyRequest()
                .requiresInsecure()
        .and()
                //Authorize request
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole(SecurityConstant.ADMIN)
                .antMatchers("/user/**").hasRole(SecurityConstant.USER)
        .and()
                .exceptionHandling().accessDeniedPage("/403")
        .and()
                // Config form login
                // default login processing url is /login and logout processsing is /logout
                .formLogin()
                .loginPage("/login").loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/")
                .successHandler(authenticationSuccessHandler)
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
        .and()
                .logout()
                .deleteCookies("JSESSIONID")
                //.logoutUrl()
                .logoutSuccessHandler(logoutSuccessHandler)
                .logoutSuccessUrl("/")
        .and()
                .rememberMe()
        .and()
                .sessionManagement()
                .sessionFixation()
                .none()
        .and()
                .apply(getSpringSocialConfigurer())
        .and()
                .sessionManagement()
                .maximumSessions(1)
                .expiredUrl("/login?expired=true");
    }

    private SpringSocialConfigurer getSpringSocialConfigurer() {
        SpringSocialConfigurer config = new SpringSocialConfigurer();
        config.alwaysUsePostLoginUrl(true);
        config.postLoginUrl("/profile");
        return config;
    }

}
