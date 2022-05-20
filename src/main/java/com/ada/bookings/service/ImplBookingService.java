package com.ada.bookings.service;

import com.ada.bookings.model.Booking;
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

    private final List<Booking> bookingList = new ArrayList<>();

    @Override
    public Booking create(Booking booking) {
        bookingList.add(booking);
        return booking;
    }

    @Override
    public Optional<Booking> findById(String id) {
        return bookingList.stream().filter(booking -> booking.getId().equals(id)).findFirst();
    }

    @Override
    public List<Booking> findAll() {
        return bookingList;
    }

    @Override
    public Booking update(String id, Booking booking) {
        return bookingList.set(bookingList.indexOf(bookingList.stream().filter(bookingToFind -> bookingToFind.getId().equals(id)).findFirst().orElseThrow(IllegalArgumentException::new)), booking);
    }

    @Override
    public void delete(String id) {
        bookingList.remove(bookingList.stream().filter(bookingToFind -> bookingToFind.getId().equals(id)).findFirst().orElseThrow(IllegalArgumentException::new));
    }

}