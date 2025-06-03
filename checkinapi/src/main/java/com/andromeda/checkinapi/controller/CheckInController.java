package com.andromeda.checkinapi.controller;

import com.andromeda.checkinapi.model.CheckIn;
import com.andromeda.checkinapi.repository.CheckInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checkin")
@CrossOrigin
public class CheckInController {

    @Autowired
    private CheckInRepository repository;

    @PostMapping
    public String registrarCheckIn(@RequestBody CheckIn checkIn) {
        repository.save(checkIn);
        return "Check-in guardado correctamente";
    }

    @GetMapping
    public List<CheckIn> obtenerTodos() {
        return repository.findAll();
    }
}
