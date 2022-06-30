package com.ada.bookings.exceptions;

import com.ada.bookings.error.ErrorCodeEnum;
import com.ada.bookings.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
public class UserNotFoundException extends InternalServerErrorException {

    public UserNotFoundException() {
        super(new ServerErrorResponseDto("User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

}