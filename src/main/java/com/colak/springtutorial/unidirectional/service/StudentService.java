package com.colak.springtutorial.unidirectional.service;

import com.colak.springtutorial.unidirectional.jpa.Address;
import com.colak.springtutorial.unidirectional.jpa.Student;
import com.colak.springtutorial.unidirectional.repository.AddressRepository;
import com.colak.springtutorial.unidirectional.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// See https://vladmihalcea.com/spring-data-jpa-findbyid/
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    private final AddressRepository addressRepository;

    @Transactional
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public Address addNewAddress(String city, String zipCode, Long studentId) {
        Address address = new Address();
        address.setCity(city);
        address.setZipCode(zipCode);

        // This is supposed to avoid a select because of getReferenceById, but it still executes a select statement.
        // I am not sure why
        Student student = studentRepository.getReferenceById(studentId);
        address.setStudent(student);

        addressRepository.save(address);

        return address;
    }
}
