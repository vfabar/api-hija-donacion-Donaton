package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DonationState;

@Repository
public interface DonationStateRepository extends JpaRepository<DonationState, Long> {
    
}
