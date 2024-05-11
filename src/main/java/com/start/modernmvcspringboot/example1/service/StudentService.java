package com.start.modernmvcspringboot.example1.service;

import com.start.modernmvcspringboot.example1.model.Student;
import com.start.modernmvcspringboot.example1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;


    public Student createStudent(Student input) {
        Student student = new Student();
        student.setName(input.getName());
        student.setAge(input.getAge());
        student.setStandard(input.getStandard());
        student.setSchool(input.getSchool());
        student.setGender(input.getGender());
        this.repository.save(student);
        return student;
    }

    public Optional<Student> updateStudent(Student input) {
        Optional<Student> student = this.repository.findById(input.getStudentId());
        if (student.isPresent()) {
            student.get().setName(input.getName());
            student.get().setAge(input.getAge());
            student.get().setStandard(input.getStandard());
            student.get().setSchool(input.getSchool());
            student.get().setGender(input.getGender());
            this.repository.save(student.get());
            return student;
        }else
            return Optional.empty();
    }

    public Optional<Student> getStudentById(String studentId) {
        return this.repository.findById(studentId);
    }

    public String deleteStudentById(String studentId) {
        Optional<Student> student = this.repository.findById(studentId);
        if (student.isPresent()) {
            this.repository.delete(student.get());
            return "Success";
        }
        else
            return "Not Success";
    }

    public List<Student> getAllStudents() {
        List<Student> students = this.repository.findAll();
        if (!students.isEmpty())
            return students;
        else
            return Collections.emptyList();
    }

}
