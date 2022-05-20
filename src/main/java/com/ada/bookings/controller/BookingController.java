package com.ada.bookings.controller;

import com.ada.bookings.model.Booking;
import com.ada.bookings.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
@RestController
@RequestMapping("/v1/bookings")
public class BookingController {

    private final IBookingService iBookingService;

    public BookingController(@Autowired IBookingService iBookingService) {
        this.iBookingService = iBookingService;
    }

    @GetMapping("/{id}")
    public Optional<Booking> findById(@PathVariable String id) {
        return iBookingService.findById(id);
    }

    @GetMapping("/all")
    public List<Booking> findAll() {
        return iBookingService.findAll();
    }

    @PostMapping("/create")
    public Booking create(@RequestBody Booking booking) {
        return iBookingService.create(booking);
    }

    @PutMapping("/{id}")
    public Booking update(@PathVariable String id, @RequestBody Booking booking) {
        return iBookingService.update(id, booking);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        iBookingService.delete(id);
    }

}