package com.ada.bookings.service;

import com.ada.bookings.entity.BookingEntity;
import com.ada.bookings.repository.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
@Service
public class ImplBookingService implements IBookingService {

    private final IBookingRepository iBookingRepository;

    public ImplBookingService(@Autowired IBookingRepository iBookingRepository) {
        this.iBookingRepository = iBookingRepository;
    }

    @Override
    public BookingEntity create(BookingEntity bookingEntity) {
        return iBookingRepository.save(bookingEntity);
    }

    @Override
    public Optional<BookingEntity> findById(Long id) {
        return iBookingRepository.findById(id);
    }

    @Override
    public List<BookingEntity> findAll() {
        return iBookingRepository.findAll();
    }

    @Override
    public BookingEntity update(Long id, BookingEntity bookingEntity) {
        Optional<BookingEntity> optionalBookingEntity = iBookingRepository.findById(id);
        bookingEntity.setId(optionalBookingEntity.orElseThrow(NullPointerException::new).getId());
        return iBookingRepository.save(bookingEntity);
    }

    @Override
    public void delete(Long id) {
        iBookingRepository.deleteById(id);
    }

}