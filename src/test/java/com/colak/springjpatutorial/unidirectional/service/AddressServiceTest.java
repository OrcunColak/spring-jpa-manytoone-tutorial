package com.colak.springjpatutorial.unidirectional.service;

import com.colak.springjpatutorial.unidirectional.jpa.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    // select * from address a1_0 left join student s1_0 on s1_0.id=a1_0.student_id where s1_0.id=? offset ? rows fetch first ? rows only

    @Test
    void testFindByStudentId() {
        Page<Address> result = addressService.findByStudentId(1L, Pageable.ofSize(1));
        assertEquals(0, result.getTotalPages());
    }
}
