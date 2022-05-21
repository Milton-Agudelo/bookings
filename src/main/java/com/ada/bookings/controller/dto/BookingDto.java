package com.ada.bookings.controller.dto;

import com.ada.bookings.model.Booking;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
public class BookingDto {

    private String id;
    private String name;
    private String date;

    public BookingDto(String id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public BookingDto(Booking booking) {
        this(booking.getId(), booking.getName(), booking.getDate());
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