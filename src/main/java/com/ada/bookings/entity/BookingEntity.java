package com.ada.bookings.entity;

import com.ada.bookings.controller.dto.BookingDto;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
@Data
@Document(value="booking")
@AllArgsConstructor
@NoArgsConstructor
public class BookingEntity {

    @Id
    private String id;
    private String name;
    private String date;
    private String author;
    @Indexed( unique = true )
    private String email;
    private String passwordHash;
    private List<RoleEnum> roles;
    private Date createdAt;


    public BookingEntity(BookingDto bookingDto) {
        this(UUID.randomUUID().toString(), bookingDto.getName(), bookingDto.getDate(), bookingDto.getAuthor(),
            bookingDto.getEmail(), BCrypt.hashpw(bookingDto.getPassword(), BCrypt.gensalt()), bookingDto.getRoles(), new Date());
    }

}