package com.ada.bookings.controller.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
@Data
@AllArgsConstructor
public class AuthenticationResponse {

    private String jwt;

}