package com.ada.bookings.repository;

import com.ada.bookings.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
public interface IBookingRepository extends JpaRepository<BookingEntity, Long> {
}