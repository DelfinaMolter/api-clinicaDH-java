package com.example.clinica.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public DataLoader(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("pass");
        String password2 = passwordEncoder.encode("pass2");

        usuarioRepository.save(new Usuario("Cleri", password, "cleri@gmail.com", UsuarioRoles.ROLE_ADMIN));
        usuarioRepository.save(new Usuario("Lucas", password2, "lucasMeli@gmail.com", UsuarioRoles.ROLE_USER));

    }
}
