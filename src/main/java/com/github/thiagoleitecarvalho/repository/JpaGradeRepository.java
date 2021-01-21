package com.github.thiagoleitecarvalho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.thiagoleitecarvalho.entity.Grade;
import com.github.thiagoleitecarvalho.entity.Student;

/**
 * Interface responsible for manipulating the Grade entity.
 * @author Thiago Leite e Carvalho
 * @see My linkedIn profile: https://www.linkedin.com/in/thiago-leite-e-carvalho-1b337b127/
 */
@Repository
public interface JpaGradeRepository extends JpaRepository<Grade, Integer> {

    /**
     * Return all grades for a student.
     * @param student Student who wants to get grades
     * @return Grades of the student
     */
    List<Grade> findByStudent(Student student);

}
