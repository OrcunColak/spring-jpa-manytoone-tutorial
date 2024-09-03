package com.colak.springtutorial.unidirectional.repository;

import com.colak.springtutorial.unidirectional.jpa.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
