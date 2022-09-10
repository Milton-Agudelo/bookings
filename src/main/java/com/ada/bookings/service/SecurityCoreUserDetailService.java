package com.ada.bookings.service;

import com.ada.bookings.repository.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
@Service
public class SecurityCoreUserDetailService implements UserDetailsService {

    private final IBookingRepository iBookingRepository;

    public SecurityCoreUserDetailService(@Autowired IBookingRepository iBookingRepository) {
        this.iBookingRepository = iBookingRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("Milton", "M1lt0n4gudel0", new ArrayList<>());
    }

}