package com.colak.springjpatutorial.unidirectional.repository;

import com.colak.springjpatutorial.unidirectional.jpa.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
