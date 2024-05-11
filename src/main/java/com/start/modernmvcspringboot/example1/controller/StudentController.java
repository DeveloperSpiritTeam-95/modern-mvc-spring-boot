package com.start.modernmvcspringboot.example1.controller;

import com.start.modernmvcspringboot.example1.model.Student;
import com.start.modernmvcspringboot.example1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/createStudent")
    public Student createStudent(@RequestBody Student student){
        return this.service.createStudent(student);
    }

    @PutMapping("/updateStudent")
    public Optional<Student> updateStudent(@RequestBody Student student){
        return this.service.updateStudent(student);
    }

    @GetMapping("/getStudentById/{studentId}")
    public Optional<Student> getStudentById(@PathVariable("studentId") String studentId){
        return this.service.getStudentById(studentId);
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
        return this.service.getAllStudents();
    }

    @DeleteMapping("/deleteStudentById/{studentId}")
    public String deleteStudentById(@PathVariable("studentId") String studentId){
        return this.service.deleteStudentById(studentId);
    }




}
