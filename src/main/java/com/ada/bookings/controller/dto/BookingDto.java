package com.ada.bookings.controller.dto;

import com.ada.bookings.entity.BookingEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
@Data
@AllArgsConstructor
public class BookingDto {

    private Long id;
    private String name;
    private String date;
    private String author;

    public BookingDto(BookingEntity bookingEntity) {
        this(bookingEntity.getId(), bookingEntity.getName(), bookingEntity.getDate(), bookingEntity.getAuthor());
    }

}