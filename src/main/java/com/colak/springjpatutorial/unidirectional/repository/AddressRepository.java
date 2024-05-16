package com.colak.springjpatutorial.unidirectional.repository;

import com.colak.springjpatutorial.unidirectional.jpa.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Page<Address> findByStudentId(Long studentId, Pageable pageable);
}
