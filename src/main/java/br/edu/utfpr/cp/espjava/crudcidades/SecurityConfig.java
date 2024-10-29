package br.edu.utfpr.cp.espjava.crudcidades;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain filter(HttpSecurity http) throws Exception {

        return http
                .authorizeHttpRequests(
                    auth -> {
                        auth.requestMatchers("/").hasAnyRole("listar", "admin");
                        auth.requestMatchers("/criar", "/excluir", "/preparaAlterar", "/alterar").hasRole("admin");
                        auth.anyRequest().denyAll();
                })
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(form -> form.loginPage("/login.html").permitAll())
                .logout(LogoutConfigurer::permitAll)
                .build();

    }

    @Bean
    public PasswordEncoder cifrador() {
        return new BCryptPasswordEncoder();
    }
}