package com.ada.bookings.service;

import com.ada.bookings.model.BookingModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
@Service
public class ImplBookingService implements IBookingService {

    private final List<BookingModel> bookingModels = new ArrayList<>();

    @Override
    public BookingModel create(BookingModel bookingModel) {
        bookingModels.add(bookingModel);
        return bookingModel;
    }

    @Override
    public Optional<BookingModel> findById(String id) {
        return bookingModels.stream().filter(bookingModel -> bookingModel.getId().equals(id)).findFirst();
    }

    @Override
    public List<BookingModel> findAll() {
        return bookingModels;
    }

}