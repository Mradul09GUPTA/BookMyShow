package com.bookmyshow.bookmyshow.models;

import java.util.List;

import com.bookmyshow.bookmyshow.models.enums.BookingStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Booking extends BaseModel {
    private String bookingnumber;
    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    @ManyToMany
    private List<ShowSeat>showseat;
    
    private double amount;

    @OneToMany
    private List<Payment> payments;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
  
    


    
}

/*

  1            1
Booking ----- User -> M:1
  M             1

    1             1
  Booking ------ Show -> M:1
    M               1

   1                M
Booking  ------- ShowSeat -> M:M
   M                1

   Booking1 -> S1 A1 -> CANCELLED
   Booking2 -> S1 A1 -> BOOKED


   Booking1 -> S1A1
   Booking1 -> S1A2


   booking_showSeats
   id, booking_id, showSeat_id

      1             M
   Booking ------ payment -> 1:M
       1             1
 */
