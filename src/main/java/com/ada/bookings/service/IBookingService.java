package com.ada.bookings.service;

import com.ada.bookings.model.Booking;

import java.util.List;
import java.util.Optional;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
public interface IBookingService {

    Booking create(Booking booking);

    Optional<Booking> findById(String id);

    List<Booking> findAll();

    Booking update(Booking booking);

    void delete(String id);

}