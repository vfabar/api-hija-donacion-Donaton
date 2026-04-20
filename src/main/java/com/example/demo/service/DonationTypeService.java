package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DonationType;
import com.example.demo.repository.DonationTypeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DonationTypeService {
    
    @Autowired
    private DonationTypeRepository donationTypeRepository;

    public List<DonationType> findAll() {
        return donationTypeRepository.findAll();
    }

    public DonationType findById(Long id) {
        return donationTypeRepository.findById(id).orElse(null);
    }

    public DonationType save(DonationType donationType) {
        return donationTypeRepository.save(donationType);
    }
    public void deleteById(Long id) {
        donationTypeRepository.deleteById(id);
    }
}
