package com.ada.bookings.controller.dto;

import com.ada.bookings.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
@Data
@AllArgsConstructor
public class UserDto {

    private String name;
    private String lastName;
    private String email;
    private String password;

    public UserDto(UserEntity userEntity) {
        this(userEntity.getName(), userEntity.getLastName(), userEntity.getEmail(), userEntity.getPasswordHash());
    }

}