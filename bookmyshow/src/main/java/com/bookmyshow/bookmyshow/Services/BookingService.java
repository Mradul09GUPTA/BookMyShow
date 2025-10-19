package com.bookmyshow.bookmyshow.Services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;


import com.bookmyshow.bookmyshow.Exception.InvalidShowException;
import com.bookmyshow.bookmyshow.Exception.InvalidShowSeatException;
import com.bookmyshow.bookmyshow.Exception.InvalidUserException;
import com.bookmyshow.bookmyshow.Repository.BookingRepo;
import com.bookmyshow.bookmyshow.Repository.ShowRepo;
import com.bookmyshow.bookmyshow.Repository.ShowSeatRepo;
import com.bookmyshow.bookmyshow.Repository.ShowSeatRepository;
import com.bookmyshow.bookmyshow.Repository.UsersRepo;
import com.bookmyshow.bookmyshow.models.Booking;
import com.bookmyshow.bookmyshow.models.Show;
import com.bookmyshow.bookmyshow.models.ShowSeat;
import com.bookmyshow.bookmyshow.models.User;
import com.bookmyshow.bookmyshow.models.enums.BookingStatus;
import com.bookmyshow.bookmyshow.models.enums.ShowSeatStatus;


@Service
public class BookingService {
    @Autowired
    UsersRepo usersRepo;
    @Autowired
    ShowRepo showRepo;

    @Autowired
    ShowSeatRepo showSeatRepo;

    @Autowired
    ShowSeatRepository showSeatRepository;
    @Autowired
    BookingRepo bookingRepository;
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(Long userid, List<Long> showSeatIds, Long showId) throws InvalidUserException, InvalidShowException, InvalidShowSeatException{
       
        User user=usersRepo.findById(userid).orElseThrow(()->new InvalidUserException("Inavlid User"));
        
        Show show =  showRepo.findById(showId).orElseThrow(()->new InvalidShowException("Invalid Show"));

        List<ShowSeat> showSeats =  showSeatRepo.findAllById(showSeatIds);

        if(showSeats.size()!=showSeatIds.size()){
            throw new InvalidShowSeatException("Invalid Seat Selected");
        }
         
          for (ShowSeat showSeat: showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            // 7. Save the changes in the DB

            // save is an upsert(update + insert) operation
            showSeatRepository.save(showSeat);
        }

        // 8. Create a booking with status as PENDING[save obj in DB]
        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setCreatedAt(new Date());
        booking.setUser(user);
        booking.setBookingnumber(UUID.randomUUID().toString());
        booking.setShow(show);
        booking.setShowseat(showSeats);
        booking.setAmount(0.0);
        
        booking = bookingRepository.save(booking);
        return null;

    }
}
