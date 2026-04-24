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

import com.example.demo.model.DonationType;
import com.example.demo.service.DonationTypeService;

@RestController
@RequestMapping("/api/v1/donation-type")
public class DonationTypeController {
    
    @Autowired
    private DonationTypeService donationTypeService;

    @GetMapping
    public ResponseEntity<List<DonationType>> getAllDonationTypes() {
        List<DonationType> donationTypes = donationTypeService.findAll();
        if (donationTypes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(donationTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonationType> getDonationTypeById(@PathVariable Long id) {
        DonationType donationType = donationTypeService.findById(id);
        if (donationType == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(donationType);
    }

    @PostMapping
    public ResponseEntity<DonationType> createDonationType(@RequestBody DonationType donationType) {
        DonationType savedDonationType = donationTypeService.save(donationType);
        return ResponseEntity.status(201).body(savedDonationType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonationType(@PathVariable Long id) {
        donationTypeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
