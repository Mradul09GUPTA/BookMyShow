package com.bookmyshow.bookmyshow.models;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@MappedSuperclass
public class BaseModel {
 @Id // PK attr for all the child classes of the BaseModel
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;
    private Date LastUpdated;
    private Date CreatedAt;  
}
