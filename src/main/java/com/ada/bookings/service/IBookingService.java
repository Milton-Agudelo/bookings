package com.ada.bookings.service;

import com.ada.bookings.entity.BookingEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
public interface IBookingService {

    BookingEntity create(BookingEntity bookingEntity);

    Optional<BookingEntity> findById(Long id);

    List<BookingEntity> findAll();

    BookingEntity update(Long id, BookingEntity bookingEntity);

    void delete(Long id);

}