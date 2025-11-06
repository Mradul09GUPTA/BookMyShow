package com.bookmyshow.bookmyshow.models;

import com.bookmyshow.bookmyshow.models.enums.SeatType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Seat extends BaseModel {

  private int rowNum;
    private int colNum;
    private String number;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;   

    @Version
    private Long version;
}
