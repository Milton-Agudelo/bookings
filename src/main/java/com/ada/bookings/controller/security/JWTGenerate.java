package com.ada.bookings.controller.security;

import com.ada.bookings.entity.BookingEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
@Component
public class JWTGenerate {

    private static final String KEY = "D4v1DM0r3N0";

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)).signWith(SignatureAlgorithm.HS256, KEY).compact();

    }

    public String generateTokenv2(BookingEntity bookingDetails) {
        return Jwts.builder().setSubject(bookingDetails.getEmail()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, KEY)
                .compact();
    }

    public boolean validateToken(String token, BookingEntity bookingEntity) {
        return bookingEntity.getEmail().equals(getEmail(token)) && !isTokenExpired(token);
    }

    public Claims getClaim(String token) {
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }

    public String getEmail(String token) {
        return getClaim(token).getSubject();
    }

    public boolean isTokenExpired(String token) {
        return getClaim(token).getExpiration().before(new Date());
    }


}