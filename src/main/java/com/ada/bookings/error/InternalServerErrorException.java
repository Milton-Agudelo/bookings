package com.ada.bookings.error;

import com.ada.bookings.exceptions.ServerErrorResponseDto;
import org.springframework.http.HttpStatus;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
public class InternalServerErrorException extends RuntimeException {

    private final ServerErrorResponseDto serverErrorResponseDto;


    private final HttpStatus httpStatus;

    public InternalServerErrorException(ServerErrorResponseDto serverErrorResponseDto, HttpStatus httpStatus) {
        this.serverErrorResponseDto = serverErrorResponseDto;
        this.httpStatus = httpStatus;
    }

    public ServerErrorResponseDto getServerErrorResponseDto() {
        return serverErrorResponseDto;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}