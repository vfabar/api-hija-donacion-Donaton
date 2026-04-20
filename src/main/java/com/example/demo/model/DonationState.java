package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "donationState")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonationState {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDonationState;

    @Column(name = "donation_state", nullable = false)
    private String donationState;
}
