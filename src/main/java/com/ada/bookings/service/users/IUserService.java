package com.ada.bookings.service.users;

import com.ada.bookings.entity.UserEntity;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
public interface IUserService {

    UserEntity save(UserEntity user);

    UserEntity findByEmail(String email);

}