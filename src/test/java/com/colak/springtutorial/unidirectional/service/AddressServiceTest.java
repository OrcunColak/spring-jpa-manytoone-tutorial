package com.colak.springtutorial.unidirectional.service;

import com.colak.springtutorial.unidirectional.jpa.Address;
import com.colak.springtutorial.unidirectional.jpa.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    // select * from address a left join student s on s.id=a.student_id where s.id=? offset ? rows fetch first ? rows only
    // select count(a.id) from address a where a.student_id=?

    @Test
    void testFindByStudentId() {
        Page<Address> result = addressService.findByStudentId(1L, Pageable.ofSize(1));
        assertEquals(1, result.getTotalPages());
    }

    @Test
    void assignStudent() {
        Address address = addressService.assignStudent(1L, 2L);
        assertThat(address.getStudent().getId()).isEqualTo(2L);
    }

    // When address is saved student is also saved
    @Test
    void saveAddressAndStudent() {
        Address address = new Address();
        address.setCity("Ankara");
        address.setZipCode("06530");

        Student student = new Student();
        student.setName("Orçun");
        student.setAge(48);
        student.setMobile("0532");
        address.setStudent(student);

        Address savedAddress = addressService.save(address);
        Student savedAddressStudent = savedAddress.getStudent();

        assertThat(savedAddressStudent.getId()).isNotNull();
    }
}
