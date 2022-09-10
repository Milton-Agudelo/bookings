package com.ada.bookings.controller;

import com.ada.bookings.controller.dto.BookingDto;
import com.ada.bookings.entity.BookingEntity;
import com.ada.bookings.service.IBookingService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    @ApiOperation(value = "This method is used to get the clients.")
    @GetMapping
    public List<BookingEntity> getClients() {
        return iBookingService.findAll();
    }

    @PostMapping
    public ResponseEntity<BookingEntity> create(@RequestBody BookingDto bookingDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iBookingService.create(new BookingEntity(bookingDto)));
    }

    @GetMapping("{id}")
    public ResponseEntity<BookingEntity> findById(@PathVariable String id) {
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("User with id: '" + id + "' can not be found!");
        Optional<BookingEntity> booking = iBookingService.findById(id);
        if (!booking.equals(Optional.empty())) {
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(iBookingService.findById(id).get());
        }
        return responseEntity;
    }

    @GetMapping("findAll/")
    public ResponseEntity<List<BookingEntity>> findAll() {
        List bookingList = new ArrayList();
        for (BookingEntity bookingEntity : iBookingService.findAll()) {
            bookingList.add(bookingEntity);
        }
        return ResponseEntity.status(HttpStatus.OK).body(bookingList);
    }

    @PutMapping("{id}")
    public ResponseEntity<BookingEntity> update(@PathVariable String id, @RequestBody BookingDto bookingDto) {
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("User with id: '" + id + "' can not be found!");
        BookingEntity bookingEntity = new BookingEntity(bookingDto);
        if (iBookingService.update(id, bookingEntity)) {
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(iBookingService.findById(id).get());
        }
        return responseEntity;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("User with id: '" + id + "' can not be found!");

        if (!iBookingService.findById(id).equals(Optional.empty())) {
            iBookingService.deleteById(id);
            responseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return responseEntity;
    }

}