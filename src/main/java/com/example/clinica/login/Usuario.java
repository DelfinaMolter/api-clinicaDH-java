package com.example.clinica.login;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;


@ToString
@Entity
public class Usuario implements UserDetails {

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Enumerated(EnumType.STRING)
    private UsuarioRoles roll;

    @Id
    @SequenceGenerator(name="user_sequence", sequenceName = "user_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long idUsuario;


    public Usuario() {
    }
    public Usuario(String username, String password, String email, UsuarioRoles roll) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.roll = roll;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority generatedAuthority = new SimpleGrantedAuthority(roll.name());
        return Collections.singletonList(generatedAuthority);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UsuarioRoles getRoll() {
        return roll;
    }

    public void setRoll(UsuarioRoles roll) {
        this.roll = roll;
    }
}
