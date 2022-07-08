package com.example.registration.repositories;

import com.example.registration.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo  extends JpaRepository<Teacher,Long> {

}
