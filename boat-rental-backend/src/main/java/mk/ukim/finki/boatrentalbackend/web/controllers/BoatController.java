package mk.ukim.finki.boatrentalbackend.web.controllers;

import mk.ukim.finki.boatrentalbackend.dto.domain.CreateBoatDto;
import mk.ukim.finki.boatrentalbackend.dto.domain.DisplayBoatDetailsDto;
import mk.ukim.finki.boatrentalbackend.dto.domain.DisplayBoatDto;
import mk.ukim.finki.boatrentalbackend.dto.domain.DisplayOrderDto;
import mk.ukim.finki.boatrentalbackend.model.domain.User;
import mk.ukim.finki.boatrentalbackend.service.application.BoatApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boats")
public class BoatController {

    private final BoatApplicationService boatApplicationService;

    public BoatController(
            BoatApplicationService boatApplicationService
    ) {
        this.boatApplicationService = boatApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<DisplayBoatDto>> findAll() {
        return ResponseEntity.ok(boatApplicationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayBoatDto> findById(@PathVariable Long id) {
        return boatApplicationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<DisplayBoatDetailsDto> findByIdWithDetails(@PathVariable Long id) {
        return boatApplicationService
                .findByIdWithDetails(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayBoatDto> save(@RequestBody CreateBoatDto createBoatDto) {
        return ResponseEntity.ok(boatApplicationService.save(createBoatDto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayBoatDto> update(@PathVariable Long id, @RequestBody CreateBoatDto createBoatDto) {
        return boatApplicationService
                .update(id, createBoatDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DisplayBoatDto> deleteById(@PathVariable Long id) {
        return boatApplicationService
                .deleteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/add-to-order")
    public ResponseEntity<DisplayOrderDto> addToOrder(@PathVariable Long id, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(boatApplicationService.addToOrder(id, user.getUsername()));
    }

    @PostMapping("/{id}/remove-from-order")
    public ResponseEntity<DisplayOrderDto> removeFromOrder(@PathVariable Long id, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(boatApplicationService.removeFromOrder(id, user.getUsername()));
    }

}
