package com.ada.bookings.controller;

import com.ada.bookings.controller.dto.BookingDto;
import com.ada.bookings.entity.BookingEntity;
import com.ada.bookings.service.bookings.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
@RestController
@RequestMapping("/v1/bookings/")
public class BookingController {

    private final IBookingService iBookingService;

    public BookingController(@Autowired IBookingService iBookingService) {
        this.iBookingService = iBookingService;
    }

    @PostMapping
    public ResponseEntity<BookingDto> create(@RequestBody BookingDto bookingDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new BookingDto(iBookingService.create(new BookingEntity(bookingDto))));
    }

    @GetMapping("{id}")
    public ResponseEntity<BookingDto> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(new BookingDto(iBookingService.findById(id).orElseThrow(IllegalArgumentException::new)));
    }

    @GetMapping
    public ResponseEntity<List<BookingDto>> findAll() {
        List<BookingDto> bookingDtos = new ArrayList<>();
        for (BookingEntity bookingEntity : iBookingService.findAll()) {
            bookingDtos.add(new BookingDto(bookingEntity));
        }
        return ResponseEntity.status(HttpStatus.OK).body(bookingDtos);
    }

    @PutMapping("{id}")
    public ResponseEntity<BookingDto> update(@PathVariable Long id, @RequestBody BookingDto bookingDto) {
        return ResponseEntity.status(HttpStatus.OK).body(new BookingDto(iBookingService.update(id, new BookingEntity(bookingDto))));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        iBookingService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}