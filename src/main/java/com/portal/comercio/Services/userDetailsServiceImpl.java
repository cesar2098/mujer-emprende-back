package com.portal.comercio.Services;

import com.portal.comercio.Models.UsuariosModel;
import com.portal.comercio.Repository.usuariosRepository;
import com.portal.comercio.dto.responseDto;
import com.portal.comercio.dto.responseDtoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userDetailsServiceImpl implements UserDetailsService {
    @Autowired
    usuariosRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user  = getbyEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        UsuariosModel usr =(UsuariosModel) user.getRespuesta();
        return User
                .withUsername(email)
                .password(usr.getPassword())
                .roles(usr.getRol())
                .build();
    }

    public responseDto getbyEmail(String email){
        //System.out.println("EMAIL: " + email);
        UsuariosModel userM = userRepo.findAll()
                .stream()
                .filter(e -> e.getUsername().equals(email))
                .findFirst()
                .orElse(null);
        //if(userM.equals(null))
         //   System.out.println("ENTIDAD NULA");
        userM.setPassword(new BCryptPasswordEncoder().encode(userM.getPassword()));
        return new responseDto(200,"Usuario Encontrado", userM, responseDtoEnum.INFO);
    }
}
