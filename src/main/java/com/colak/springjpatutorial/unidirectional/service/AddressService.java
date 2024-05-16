package com.colak.springjpatutorial.unidirectional.service;

import com.colak.springjpatutorial.unidirectional.jpa.Address;
import com.colak.springjpatutorial.unidirectional.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    Page<Address> findByStudentId(Long studentId, Pageable pageable) {
        return addressRepository.findByStudentId(studentId, pageable);
    }
}
