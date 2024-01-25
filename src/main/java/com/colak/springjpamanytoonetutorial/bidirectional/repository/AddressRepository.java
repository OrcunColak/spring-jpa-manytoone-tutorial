package com.colak.springjpamanytoonetutorial.bidirectional.repository;

import com.colak.springjpamanytoonetutorial.bidirectional.jpa.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Page<Address> findByStudentId(Long studentId, Pageable pageable);
}
