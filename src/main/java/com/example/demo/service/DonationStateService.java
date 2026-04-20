package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DonationState;
import com.example.demo.repository.DonationStateRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DonationStateService {
    @Autowired
    private DonationStateRepository donationStateRepository;

    public List<DonationState> findAll() {
        return donationStateRepository.findAll();
    }

    public DonationState findById(Long id) {
        return donationStateRepository.findById(id).orElse(null);
    }

    public DonationState save(DonationState donationState) {
        return donationStateRepository.save(donationState);
    }
    public void deleteById(Long id) {
        donationStateRepository.deleteById(id);
    }
}
