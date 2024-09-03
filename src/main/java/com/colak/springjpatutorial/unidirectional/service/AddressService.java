package com.colak.springjpatutorial.unidirectional.service;

import com.colak.springjpatutorial.unidirectional.jpa.Address;
import com.colak.springjpatutorial.unidirectional.jpa.Student;
import com.colak.springjpatutorial.unidirectional.repository.AddressRepository;
import com.colak.springjpatutorial.unidirectional.repository.StudentRepository;
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
        Student studentProxy = studentRepository.getReferenceById(studentId);

        address.setStudent(studentProxy);
        return addressRepository.save(address);
    }
}
