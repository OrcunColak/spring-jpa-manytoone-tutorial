package com.colak.springtutorial.unidirectional.service;

import com.colak.springtutorial.unidirectional.jpa.Address;
import com.colak.springtutorial.unidirectional.jpa.Student;
import com.colak.springtutorial.unidirectional.repository.AddressRepository;
import com.colak.springtutorial.unidirectional.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final StudentRepository studentRepository;

    @Transactional
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Transactional(readOnly = true)
    public Page<Address> findByStudentId(Long studentId, Pageable pageable) {
        return addressRepository.findByStudentId(studentId, pageable);
    }

    // See https://medium.com/@fr13.dev/secrets-to-efficient-jpa-usage-lazy-loading-of-entities-66e7761c12ac
    // Assign Address to a new student
    @Transactional
    public Address assignStudent(Long addressId, Long studentId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(EntityNotFoundException::new);

        // Get a proxy
        // Similar to "entityManager.getReference(Student.class, studentId);"
        Student studentProxy = studentRepository.getReferenceById(studentId);

        address.setStudent(studentProxy);
        return addressRepository.save(address);
    }
}
