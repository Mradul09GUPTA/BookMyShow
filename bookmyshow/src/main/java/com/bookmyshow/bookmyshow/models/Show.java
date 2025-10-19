package com.bookmyshow.bookmyshow.models;

import java.sql.Date;
import java.util.List;

import com.bookmyshow.bookmyshow.models.enums.Feature;
import com.bookmyshow.bookmyshow.models.enums.Language;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "shows")

public class Show extends BaseModel {

    @ManyToOne
    private Movie movie;


    private Date startTime;
    private Date endTime;

    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

     @Enumerated(EnumType.ORDINAL)
    private Language language;
}
