package com.example.registration.controllers;

import com.example.registration.models.Student;
import com.example.registration.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*")
@RestController
public class StudentController {
    @Autowired
    private StudentRepo studentRepo;


    @GetMapping("/student")
    public List<Student> getAllStudent(){
        return studentRepo.findAll();
    }

    @GetMapping("/student/{id}")
    public Optional<Student> findById(@PathVariable Long id){
        return studentRepo.findById(id);
    }


    @PostMapping("/student")
    public Student addNewstudent(@RequestBody Student newStudent){
        return studentRepo.save(newStudent);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable Long id){
         studentRepo.deleteById(id);
    }
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student replaceStudent){
        if (studentRepo.findById(replaceStudent.getId()).isPresent()){
            return new ResponseEntity<>(studentRepo.save(replaceStudent), HttpStatus.OK);

        }
        else{
            return new ResponseEntity(replaceStudent,HttpStatus.BAD_REQUEST);
        }
    }


}
