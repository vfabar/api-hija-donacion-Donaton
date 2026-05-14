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

import com.example.demo.model.Donation;
import com.example.demo.service.DonationService;

@RestController
@RequestMapping("/donation")
public class DonationController {
    
    @Autowired
    private DonationService donationService;

    @GetMapping
    public ResponseEntity<List<Donation>> getAllDonations() {
        List<Donation> donations = donationService.findAll();
        if (donations.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(donations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donation> getDonationById(@PathVariable Long id) {
        Donation donation = donationService.findById(id);
        if (donation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(donation);
    }

    @PostMapping
    public ResponseEntity<Donation> createDonation(@RequestBody Donation donation) {
        Donation savedDonation = donationService.save(donation);
        return ResponseEntity.status(201).body(savedDonation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonation(@PathVariable Long id) {
        donationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
