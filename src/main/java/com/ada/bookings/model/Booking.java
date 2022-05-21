package com.ada.bookings.model;

import com.ada.bookings.controller.dto.BookingDto;

import java.util.UUID;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
public class Booking {

    private String id;
    private String name;
    private String date;

    public Booking(String id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Booking(BookingDto bookingDto) {
        this(bookingDto.getId() != null ? bookingDto.getId() : UUID.randomUUID().toString(), bookingDto.getName(), bookingDto.getDate());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}