package com.ada.bookings.controller.auth;

import com.ada.bookings.controller.security.JWTGenerate;
import com.ada.bookings.entity.UserEntity;
import com.ada.bookings.exceptions.InvalidCredentialsException;
import com.ada.bookings.service.users.ImplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JWTGenerate jwtGenerate;
    private final ImplUserService implUserService;

    public AuthController(@Autowired ImplUserService implUserService, @Autowired JWTGenerate jwtGenerate) {
        this.implUserService = implUserService;
        this.jwtGenerate = jwtGenerate;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        UserEntity user = implUserService.findByEmail(request.getEmail());
        String jwt = "";
        if (BCrypt.checkpw(request.getPassword(), user.getPasswordHash())) {
            jwt = jwtGenerate.generateTokenv2(user);
            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        } else {
            throw new InvalidCredentialsException();
        }
    }

}