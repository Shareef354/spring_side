package com.example.registration.controllers;

import com.example.registration.models.Administrator;
import com.example.registration.repositories.AdministratorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AdministratorController {
    @Autowired
    public AdministratorRepo administratorRepo;

    @GetMapping("/administrator")
    public List<Administrator>getAllAdministrator(){
        return administratorRepo.findAll();
    }
    @GetMapping("/admin/{id}")
    public Optional<Administrator> getById(@PathVariable Long id){
        return administratorRepo.findById(id);
    }


    @PostMapping("/admin")
    public Administrator addNewAdmin(@RequestBody Administrator newAdmin){
        return administratorRepo.save(newAdmin);
    }

    @DeleteMapping("/admin/{id}")
    public void deleteAdmin(@PathVariable Long id){
        administratorRepo.deleteById(id);
    }
    @PutMapping("/admin/{id}")
    public ResponseEntity<Administrator> updateAdministrator(@RequestBody Administrator replaceAdmin){
        if (administratorRepo.findById(replaceAdmin.getId()).isPresent()){
            return new ResponseEntity<Administrator>(administratorRepo.save(replaceAdmin), HttpStatus.OK);

        }
        else{
            return new ResponseEntity(replaceAdmin,HttpStatus.BAD_REQUEST);
        }
    }
}
