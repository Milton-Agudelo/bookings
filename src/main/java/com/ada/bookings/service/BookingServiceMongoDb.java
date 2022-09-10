package com.ada.bookings.service;

import com.ada.bookings.entity.BookingEntity;
import com.ada.bookings.exceptions.UserNotFoundException;
import com.ada.bookings.repository.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceMongoDb implements IBookingService {

    private final IBookingRepository iBookingRepository;

    public BookingServiceMongoDb(@Autowired IBookingRepository iBookingRepository) {
        this.iBookingRepository = iBookingRepository;
    }

    @Override
    public BookingEntity create(BookingEntity BookingEntity) {
        return iBookingRepository.save(BookingEntity);
    }

    @Override
    public Optional<BookingEntity> findById(String id) {
        return iBookingRepository.findById(id);
    }

    @Override
    public BookingEntity findByEmail(String email) throws UserNotFoundException {

            if(!email.equals("")){
                Optional<BookingEntity> BookingEntity = iBookingRepository.findFirstByEmail(email);
                if (BookingEntity.isPresent()){
                    return BookingEntity.get();
                } else {
                    throw new UserNotFoundException();
                }
            }
            throw new UserNotFoundException();
        }

    @Override
    public List<BookingEntity> findAll() {
        return iBookingRepository.findAll();
    }

    @Override
    public boolean deleteById(String id) {
        boolean result = false;
        Optional<BookingEntity> user = iBookingRepository.findById(id);
        if (!user.equals(Optional.empty())) {
            iBookingRepository.deleteById(id);
            result = true;
        }
        return result;
    }

    public boolean update(String id, BookingEntity bookingEntity) {
        boolean result = false;
        Optional<BookingEntity> userToUpdate = iBookingRepository.findById(id);
        if (!userToUpdate.equals(Optional.empty())) {
            bookingEntity.setId(id);
            iBookingRepository.save(bookingEntity);
            result = true;
        }
        return result;
    }

}