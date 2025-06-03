package com.andromeda.checkinapi.repository;

import com.andromeda.checkinapi.model.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckInRepository extends JpaRepository<CheckIn, Long> {

}
