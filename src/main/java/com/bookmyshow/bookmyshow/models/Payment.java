package com.bookmyshow.bookmyshow.models;


import com.bookmyshow.bookmyshow.models.enums.PaymentMode;
import com.bookmyshow.bookmyshow.models.enums.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    private String referenceNumber;
    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;
    private double amount;
    @Enumerated(EnumType.ORDINAL)
    PaymentStatus paymentStatus;
}
