package com.ada.bookings.controller.auth;

import com.ada.bookings.controller.security.JWTGenerate;
import com.ada.bookings.entity.BookingEntity;
import com.ada.bookings.exceptions.InvalidCredentialsException;
import com.ada.bookings.service.BookingServiceMongoDb;
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
@RequestMapping("/v1/auth")
public class AuthController {

    private final JWTGenerate jwtGenerate;
    private final BookingServiceMongoDb bookingService;
    //@Autowired
    //bookingServiceMongoDb bookingService;

    public AuthController(@Autowired BookingServiceMongoDb bookingService, @Autowired JWTGenerate jwtGenerate) {
        this.bookingService = bookingService;
        this.jwtGenerate = jwtGenerate;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        BookingEntity booking = bookingService.findByEmail(request.getEmail());
        String jwt = "";
       if (BCrypt.checkpw(request.getPassword(), booking.getPasswordHash())) {
            jwt = jwtGenerate.generateTokenv2(booking);
            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        } else {
            throw new InvalidCredentialsException();
        }
    }

}