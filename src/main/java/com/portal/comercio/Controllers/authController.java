package com.portal.comercio.Controllers;


import com.portal.comercio.Models.AuthenticationModel;
import com.portal.comercio.Models.TokenInfo;
import com.portal.comercio.Services.jwtUtilService;
import com.portal.comercio.Utils.utilClass;
import com.portal.comercio.dto.responseDto;
import com.portal.comercio.dto.responseDtoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comercio/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class authController {

    @Autowired
    private jwtUtilService jwtUService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    UserDetailsService usuarioDetailsService;
    @RequestMapping(method = RequestMethod.POST)
    public responseDto authUser(@RequestBody AuthenticationModel authenticationModel){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationModel.getUsuario(), utilClass.encriptarAMD5(authenticationModel.getClave())
                ));

        //System.out.println("AUTHMODEL GET USER " + authenticationModel.getUsuario());
        final UserDetails userDetails = usuarioDetailsService.loadUserByUsername(
                authenticationModel.getUsuario());

        final String jwt = jwtUService.generateToken(userDetails);

        return new responseDto(200, "Token Generado", new TokenInfo(jwt), responseDtoEnum.INFO);
    }
}
