package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserType;
import com.example.demo.repository.UserTypeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserTypeService {
    
    @Autowired
    private UserTypeRepository userTypeRepository;

    public List<UserType> findAll() {
        return userTypeRepository.findAll();
    }

    public UserType findById(Long id) {
        return userTypeRepository.findById(id).orElse(null);
    }

    public UserType save(UserType userType) {
        return userTypeRepository.save(userType);
    }
    public void deleteById(Long id) {
        userTypeRepository.deleteById(id);
    }

}
