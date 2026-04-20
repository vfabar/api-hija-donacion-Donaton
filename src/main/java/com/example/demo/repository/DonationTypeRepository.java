package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DonationType;

@Repository
public interface DonationTypeRepository extends JpaRepository<DonationType, Long> {
    
}
