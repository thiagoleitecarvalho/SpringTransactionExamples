package com.github.thiagoleitecarvalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.thiagoleitecarvalho.entity.Student;

/**
 * Interface responsible for manipulating the Student entity.
 * @author Thiago Leite e Carvalho
 * @see My linkedIn profile: https://www.linkedin.com/in/thiago-leite-e-carvalho-1b337b127/
 */
@Repository
public interface JpaStudentRepository extends JpaRepository<Student, Integer> {

    /**
     * Finds a student by you registration number.
     * @param registrationNumber Registration number
     * @return Stundent or null
     */
    Student findByRegistrationNumber(String registrationNumber);
}
