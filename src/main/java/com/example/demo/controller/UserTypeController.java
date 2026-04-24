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

import com.example.demo.model.UserType;
import com.example.demo.service.UserTypeService;

@RestController
@RequestMapping("/api/v1/user-types")
public class UserTypeController {
    
    @Autowired
    private UserTypeService userTypeService;

    @GetMapping
    public ResponseEntity<List<UserType>> getAllUserTypes() {
        List<UserType> userTypes = userTypeService.findAll();
        if (userTypes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserType> getUserTypeById(@PathVariable Long id) {
        UserType userType = userTypeService.findById(id);
        if (userType == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userType);
    }

    @PostMapping
    public ResponseEntity<UserType> createUserType(@RequestBody UserType userType) {
        UserType savedUserType = userTypeService.save(userType);
        return ResponseEntity.status(201).body(savedUserType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserType(@PathVariable Long id) {
        userTypeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}


