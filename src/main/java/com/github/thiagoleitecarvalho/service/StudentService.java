package com.github.thiagoleitecarvalho.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.thiagoleitecarvalho.entity.Student;
import com.github.thiagoleitecarvalho.exception.FakeErrorException;
import com.github.thiagoleitecarvalho.repository.JpaStudentRepository;

/**
 * Business class for Student entity.
 * @author Thiago Leite e Carvalho
 * @see My linkedIn profile: https://www.linkedin.com/in/thiago-leite-e-carvalho-1b337b127/
 */
@Service
public class StudentService {

    /** {@link JpaStudentRepository}. */
    @Autowired
    private JpaStudentRepository studentRepository;

    /**
     * Save a student. This method has no defined propagation and isolation.
     * @param student Student to save
     */
    public void save(Student student) {
        this.studentRepository.save(student);
    }

    /**
     * Save a student.
     * @param student Student to save
     */
    @Transactional(propagation = Propagation.MANDATORY)
    public void saveMandatory(Student student) {
        this.studentRepository.save(student);
    }

    /**
     * Save a student.
     * @param student Student to save
     */
    @Transactional(propagation = Propagation.NEVER)
    public void saveNever(Student student) {
        this.studentRepository.save(student);
    }

    /**
     * Save a student.
     * @param student Student to save
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void saveNotSupported(Student student) {
        this.studentRepository.save(student);
        throw new FakeErrorException("Error saving student ".concat(student.toString()));
    }

    /**
     * Save a student.
     * @param student Student to save
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveRequiredNew(Student student) {
        this.studentRepository.save(student);
    }

    /**
     * Save a student.
     * @param student Student to save
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public void saveSupports(Student student) {
        this.studentRepository.save(student);
    }
}
