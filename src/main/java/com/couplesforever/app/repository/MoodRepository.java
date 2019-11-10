package com.couplesforever.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.couplesforever.app.model.MoodMeter;

@Repository
public interface MoodRepository extends JpaRepository<MoodMeter, Integer>{

}
