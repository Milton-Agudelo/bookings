package com.ada.bookings.controller.booking;

import com.ada.bookings.controller.BookingController;
import com.ada.bookings.entity.BookingEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class BookingControllerTest {

    Random rand = new Random();

    @Autowired
    BookingController bookingController;


    @Test
    void testQueryAllBookingSuccessfully() {
        // Arrange

        // Act
        ResponseEntity<List<BookingEntity>> bookingsList = bookingController.findAll();
        int bookingsListSize = bookingsList.getBody().size();

        //Assert
        assertThat("bookings list size: ", bookingsListSize, greaterThan(0));
        int randPos = rand.nextInt(bookingsListSize-1);

        assertThat("Object type", bookingsList, instanceOf(ResponseEntity.class));
        assertThat("Object type", bookingsList.getBody(), instanceOf(List.class));
        assertThat("Object type", bookingsList.getBody().get(randPos), instanceOf(BookingEntity.class));

        for (BookingEntity booking: bookingsList.getBody()) {
            assertThat("Id", booking.getId(), is(notNullValue()));
            assertThat("Name", booking.getName(), is(notNullValue()));
            assertThat("Email", booking.getEmail(), is(notNullValue()));
            assertThat("Date", booking.getDate(), is(notNullValue()));
            assertThat("Password hash", booking.getPasswordHash(), is(notNullValue()));
            assertThat("Roles", booking.getRoles().size(), is(greaterThan(0)));
            assertThat("Author", booking.getAuthor(), is(notNullValue()));
            assertThat("Created At", booking.getCreatedAt(), is(notNullValue()));
        }
    }

}
