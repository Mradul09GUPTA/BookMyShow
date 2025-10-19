package com.bookmyshow.bookmyshow.models;

import java.sql.Date;
import java.util.List;

import com.bookmyshow.bookmyshow.models.enums.Feature;
import com.bookmyshow.bookmyshow.models.enums.Language;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

@Entity
public class Movie extends BaseModel {

    private String name;
    private Date releaseDate;
    @Enumerated(EnumType.ORDINAL)
    private List<Feature>feature;
    @Enumerated(EnumType.ORDINAL)
    private List<Language>languages;
}
