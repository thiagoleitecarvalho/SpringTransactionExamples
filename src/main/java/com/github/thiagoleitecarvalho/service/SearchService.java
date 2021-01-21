package com.github.thiagoleitecarvalho.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.thiagoleitecarvalho.entity.Grade;
import com.github.thiagoleitecarvalho.entity.Student;
import com.github.thiagoleitecarvalho.repository.JpaGradeRepository;
import com.github.thiagoleitecarvalho.repository.JpaStudentRepository;

/**
 * Business class for searches by student and grade entities.
 * @author Thiago Leite e Carvalho
 * @see My linkedIn profile: https://www.linkedin.com/in/thiago-leite-e-carvalho-1b337b127/
 */
@Service
public class SearchService {

    /**
     * Log.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchService.class);

    /** {@link JpaStudentRepository}. */
    @Autowired
    private JpaStudentRepository studentRepository;

    /** {@link JpaGradeRepository}. */
    @Autowired
    private JpaGradeRepository gradeRepository;

    /**
     * Show all students saved. This method has no defined propagation and isolation.
     */
    public void listAllStudents() {

        List<Student> students = this.studentRepository.findAll();

        for (Student student : students) {

            LOGGER.info("Name: ".concat(student.getName()));
            LOGGER.info("Registration Number: ".concat(student.getRegistrationNumber()));
        }
    }

    /**
     * Returns all students saved. This method has no defined propagation and isolation.
     * @return All student saved for the examples
     */
    public List<Student> findAllStudents() {
        return this.studentRepository.findAll();
    }

    /**
     * Show a students by your registration number.
     * @param registrationNumber Student's registration number
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void findStudentByRegistrationNumber(String registrationNumber) {

        Student student = this.studentRepository.findByRegistrationNumber(registrationNumber);

        if (student == null) {
            LOGGER.info("Student not found for registration number ".concat(registrationNumber));
            return;
        }

        LOGGER.info("Name: ".concat(student.getName()));
        LOGGER.info("Registration Number: ".concat(student.getRegistrationNumber()));
    }

    /**
     * Show the student's grades.
     * @param student Student
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void listAllStudentsGrade(Student student) {

        List<Grade> grades = this.gradeRepository.findByStudent(student);

        if (grades.isEmpty()) {
            LOGGER.info("No grades for the student ".concat(student.toString()));
            return;
        }

        for (Grade grade : grades) {

            LOGGER.info("Grade: ".concat(String.valueOf(grade.getGrade())));
            LOGGER.info("Discipline: ".concat(grade.getDiscipline()));
            LOGGER.info("Student: ".concat(grade.getStudent().getName()));
        }
    }

    /**
     * Show a students by your registration number. This method has no defined propagation and isolation.
     * @param registrationNumber Student's registration number
     */
    public void findStudentByRegistrationNumberWithoutTransaction(String registrationNumber) {

        Student student = this.studentRepository.findByRegistrationNumber(registrationNumber);

        if (student == null) {
            LOGGER.info("Student not found for registration number ".concat(registrationNumber));
            return;
        }

        LOGGER.info("Name: ".concat(student.getName()));
        LOGGER.info("Registration Number: ".concat(student.getRegistrationNumber()));
    }

}
