package com.ada.bookings.controller.security;

import com.ada.bookings.entity.UserEntity;
import com.ada.bookings.service.users.ImplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
@Component
public class JwtFilterRequest extends OncePerRequestFilter {

    @Autowired
    private JWTGenerate jwtGenerate;

    @Autowired
    private ImplUserService implUserService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String autorizationHeader = request.getHeader("Authorization");
        if (autorizationHeader != null && autorizationHeader.startsWith("Bearer")) {
            String jwt = autorizationHeader.substring(7);
            String email = jwtGenerate.getEmail(jwt);
            if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserEntity user = implUserService.findByEmail(email);
                if (jwtGenerate.validateToken(jwt, user)) {
                    SecurityContextHolder.getContext().setAuthentication(new TokenAuthentication(jwt, email, null));
                    request.setAttribute("claims", jwtGenerate.getClaim(jwt));
                    request.setAttribute("subject", jwtGenerate.getClaim(jwt).getSubject());
                    request.setAttribute("roles", null);
                }
            }
        }
        filterChain.doFilter(request, response);
    }

}