package com.ada.bookings.service.users;

import com.ada.bookings.entity.UserEntity;
import com.ada.bookings.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
@Service
public class ImplUserService implements IUserService {

    private final IUserRepository iUserRepository;

    public ImplUserService(@Autowired IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public UserEntity save(UserEntity user) {
        return iUserRepository.save(user);
    }

    @Override
    public UserEntity findByEmail(String email) {
        if (!email.equals("")) {
            Optional<UserEntity> user = iUserRepository.findFirstByEmail(email);
            return user.orElse(null);
        }
        return null;
    }

}