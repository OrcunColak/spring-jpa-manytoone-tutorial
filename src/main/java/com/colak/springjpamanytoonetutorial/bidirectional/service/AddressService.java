package com.colak.springjpamanytoonetutorial.bidirectional.service;

import com.colak.springjpamanytoonetutorial.bidirectional.jpa.Address;
import com.colak.springjpamanytoonetutorial.bidirectional.repository.AddressRepository;
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
