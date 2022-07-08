package com.example.registration.controllers;

import com.example.registration.models.Teacher;
import com.example.registration.repositories.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeacherController {
    @Autowired
    public TeacherRepo teacherRepo;


    @GetMapping("/teacher")
    public List<Teacher> getAllTeacher(){
        return teacherRepo.findAll();

    }

    @GetMapping("/teacher/{id}")
    public Optional<Teacher> getById(@PathVariable Long id) {
        return teacherRepo.findById(id);
    }

    @PostMapping("/teacher")
    public Teacher addNewTeacher(@RequestBody Teacher newTeacher) {
        return teacherRepo.save(newTeacher);
    }

    @DeleteMapping("/teacher/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherRepo.deleteById(id);
    }
    @PutMapping("/teacher")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher replaceTeacher){
        if (teacherRepo.findById(replaceTeacher.getId()).isPresent()){
            return new ResponseEntity<>(teacherRepo.save(replaceTeacher), HttpStatus.OK);

        }
        else{
            return new ResponseEntity(replaceTeacher, HttpStatus.BAD_REQUEST);
        }
    }

}
