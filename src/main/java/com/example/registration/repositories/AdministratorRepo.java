package com.example.registration.repositories;

import com.example.registration.models.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepo extends JpaRepository<Administrator,Long> {
}
