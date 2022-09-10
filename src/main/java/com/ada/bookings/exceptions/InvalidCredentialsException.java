package com.ada.bookings.exceptions;

import com.ada.bookings.error.ErrorCodeEnum;
import com.ada.bookings.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
public class InvalidCredentialsException extends InternalServerErrorException {

    public InvalidCredentialsException() {
        super(new ServerErrorResponseDto("Invalid username or password", ErrorCodeEnum.INVALID_USER_CREDENTIALS, HttpStatus.UNAUTHORIZED), HttpStatus.UNAUTHORIZED);
    }

}