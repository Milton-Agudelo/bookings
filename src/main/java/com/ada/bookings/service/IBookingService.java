package com.ada.bookings.service;

import com.ada.bookings.model.BookingModel;

import java.util.List;
import java.util.Optional;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
public interface IBookingService {

    BookingModel create(BookingModel bookingModel);

    Optional<BookingModel> findById(String id);

    List<BookingModel> findAll();

}