package uz.pdp.apppcmarketsecu.config;

import jdk.internal.dynalink.support.NameCodec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("super-admin").password(passwordEncoder().encode("admin123")).roles("SUPER_ADMIN").authorities("READ_ALL_PRODUCT", "READ_ONE_PRODUCT", "ADD_PRODUCT", "EDIT_PRODUCT", "DELETE_PRODUCT")
                .and()
                .withUser("moderator").password(passwordEncoder().encode("moderator123")).roles("MODERATOR").authorities("READ_ALL_PRODUCT", "READ_ONE_PRODUCT", "ADD_PRODUCT", "EDIT_PRODUCT")
                .and()
                .withUser("operator").password(passwordEncoder().encode("operator123")).roles("OPERATOR").authorities("READ_ALL_PRODUCT", "READ_ONE_PRODUCT", "ADD_PRODUCT");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
