package com.ada.bookings.controller;

import com.ada.bookings.controller.dto.BookingDto;
import com.ada.bookings.model.BookingModel;
import com.ada.bookings.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @PostMapping("/create")
    public BookingDto create(@RequestBody BookingDto bookingDto) {
        return new BookingDto(iBookingService.create(new BookingModel(bookingDto)));
    }

    @GetMapping("/{id}")
    public BookingDto findById(@PathVariable String id) {
        return new BookingDto(iBookingService.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    @GetMapping("/all")
    public List<BookingDto> findAll() {
        List<BookingDto> bookingDtos = new ArrayList<>();
        for (BookingModel bookingModel : iBookingService.findAll()) {
            bookingDtos.add(new BookingDto(bookingModel));
        }
        return bookingDtos;
    }

    @PutMapping("/{id}")
    public BookingDto update(@PathVariable String id, @RequestBody BookingDto bookingDto) {
        bookingDto.setId(id);
        return new BookingDto(iBookingService.update(new BookingModel(bookingDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        iBookingService.delete(id);
    }
}