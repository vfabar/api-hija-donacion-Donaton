package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Donation;
import com.example.demo.repository.DonationRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DonationService {
    
    @Autowired
    private DonationRepository donationRepository;

    public List<Donation> findAll() {
        return donationRepository.findAll();
    }

    public Donation findById(Long id) {
        return donationRepository.findById(id).orElse(null);
    }

    public Donation save(Donation donation) {
        return donationRepository.save(donation);
    }
    public void deleteById(Long id) {
        donationRepository.deleteById(id);
    }    
}
