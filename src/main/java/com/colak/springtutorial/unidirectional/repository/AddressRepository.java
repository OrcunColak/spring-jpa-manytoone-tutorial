package com.colak.springtutorial.unidirectional.repository;

import com.colak.springtutorial.unidirectional.jpa.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

    // select * from address a left join student s on s.id=a.student_id where s.id=? offset ? rows fetch first ? rows only
    Page<Address> findByStudentId(Long studentId, Pageable pageable);
}
