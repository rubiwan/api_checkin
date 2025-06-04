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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCheckIn(@PathVariable Long id) {
        Optional<CheckIn> checkIn = repository.findById(id);
        if (checkIn.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok("Check-in eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Check-in no encontrado");
        }
    }
}
