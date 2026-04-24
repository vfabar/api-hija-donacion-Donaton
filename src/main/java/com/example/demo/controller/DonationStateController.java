package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DonationState;
import com.example.demo.service.DonationStateService;

@RestController
@RequestMapping("/api/v1/donation-state")
public class DonationStateController {
    
    @Autowired
    private DonationStateService donationStateService;

    @GetMapping
    public ResponseEntity<List<DonationState>> getAllDonationStates() {
        List<DonationState> donationStates = donationStateService.findAll();
        if (donationStates.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(donationStates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonationState> getDonationStateById(@PathVariable Long id) {
        DonationState donationState = donationStateService.findById(id);
        if (donationState == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(donationState);
    }

    @PostMapping
    public ResponseEntity<DonationState> createDonationState(@RequestBody DonationState donationState) {
        DonationState savedDonationState = donationStateService.save(donationState);
        return ResponseEntity.status(201).body(savedDonationState);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonationState(@PathVariable Long id) {
        donationStateService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
