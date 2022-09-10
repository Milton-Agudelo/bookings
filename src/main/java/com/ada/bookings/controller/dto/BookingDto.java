package com.ada.bookings.controller.dto;

import com.ada.bookings.entity.RoleEnum;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
@Data
public class BookingDto {

    private String id;
    private String name;
    private String date;
    private String author;
    private String email;
    private String password;
    private List<RoleEnum> roles;
    private Date createdAt;

}