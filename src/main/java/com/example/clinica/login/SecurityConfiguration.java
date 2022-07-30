package com.example.clinica.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                /*.antMatchers("/", "crearPaciente","/crearTurno", "/modificarTurno**","/modificarPaciente**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                .antMatchers( "/crearOdontologo", "/modificarOdontologo**").access("hasRole('ROLE_ADMIN')")*/
                .antMatchers("/v1/**")
                .permitAll()
                /*.antMatchers("/v1/paciente/**","/v1/paciente","/v1/turno/**","/v1/turno", "/v1/odontologo").access("hasRole('ROLE_USER') or hasRole ('ROLE_ADMIN')")
                .antMatchers( "/v1/odontologo/**").access("hasRole ('ROLE_ADMIN')")*/
                .anyRequest()
                .authenticated()
                .and().formLogin()
                .and().logout();
        http.headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(usuarioService);
        return provider;
    }
}
