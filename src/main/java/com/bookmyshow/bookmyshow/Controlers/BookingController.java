package com.bookmyshow.bookmyshow.Controlers;

import org.springframework.stereotype.Controller;

//import org.springframework.web.bind.annotation.ResponseStatus;

import com.bookmyshow.bookmyshow.Services.BookingService;
import com.bookmyshow.bookmyshow.dtos.CreateBookingRequestDto;
import com.bookmyshow.bookmyshow.dtos.CreateBookingResponseDto;

import com.bookmyshow.bookmyshow.models.Booking;

@Controller

public class BookingController {
     private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public CreateBookingResponseDto createBooking(CreateBookingRequestDto requestDto) {
        CreateBookingResponseDto responseDto = new CreateBookingResponseDto();

        try {
            Booking booking = bookingService.createBooking(
                    requestDto.getUserId(),
                    requestDto.getShowSeatIds(),
                    requestDto.getShowId()
            );
            responseDto.setBookingId(booking.getId());
            responseDto.setResponseStatus(com.bookmyshow.bookmyshow.dtos.ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(com.bookmyshow.bookmyshow.dtos.ResponseStatus.FAILURE);
        }

        return responseDto;
    }
}
