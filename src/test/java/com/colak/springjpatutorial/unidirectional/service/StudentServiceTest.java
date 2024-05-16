package com.colak.springjpatutorial.unidirectional.service;

import com.colak.springjpatutorial.unidirectional.jpa.Address;
import com.colak.springjpatutorial.unidirectional.jpa.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void addNewAddress() {

        Student student = new Student();
        student.setName("John");
        student.setAge(48);
        student.setMobile("12345");
        Student savedStudent = studentService.save(student);

        Address savedAddress = studentService.addNewAddress("New York", "20879", savedStudent.getId());
        assertThat(savedAddress.getId()).isNotNull();

    }
}