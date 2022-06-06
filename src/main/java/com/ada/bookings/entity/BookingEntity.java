package com.ada.bookings.entity;

import com.ada.bookings.controller.dto.BookingDto;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private String date;
    private String author;

    public BookingEntity(String name, String date, String author) {
        this.name = name;
        this.date = date;
        this.author = author;
    }

    public BookingEntity(BookingDto bookingDto) {
        this(bookingDto.getName(), bookingDto.getDate(), bookingDto.getAuthor());
    }

}