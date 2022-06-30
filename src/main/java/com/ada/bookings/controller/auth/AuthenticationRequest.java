package com.ada.bookings.controller.auth;

import lombok.Data;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
@Data
public class AuthenticationRequest {

    private String email;
    private String password;

}