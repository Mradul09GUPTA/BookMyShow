package com.bookmyshow.bookmyshow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmyshow.bookmyshow.models.ShowSeat;
@Repository
public interface ShowSeatRepo extends JpaRepository<ShowSeat,Long> {
    
}
