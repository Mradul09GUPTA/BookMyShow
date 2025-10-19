package com.bookmyshow.bookmyshow.dtos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookingRequestDto {
    private Long userId;
    private Long showId; // Can be skipped because we can find it out from showSeatIds
    private List<Long> showSeatIds;
}
