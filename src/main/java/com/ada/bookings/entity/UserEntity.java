package com.ada.bookings.entity;

import com.ada.bookings.controller.dto.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;
import java.util.Date;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String passwordHash;
    private String createdAt;

    public UserEntity(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        createdAt = new Date().toString();
        passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public UserEntity(UserDto userDto) {
        this(userDto.getName(), userDto.getLastName(), userDto.getEmail(), userDto.getPassword());
    }

    public void update(UserDto userDto) {
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        if (userDto.getPassword() != null) {
            this.passwordHash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
        }
    }

}