package com.github.thiagoleitecarvalho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.thiagoleitecarvalho.entity.Grade;
import com.github.thiagoleitecarvalho.exception.FakeErrorException;
import com.github.thiagoleitecarvalho.repository.JpaGradeRepository;

/**
 * Business class for Grade entity.
 * @author Thiago Leite e Carvalho
 * @see My linkedIn profile: https://www.linkedin.com/in/thiago-leite-e-carvalho-1b337b127/
 */
@Service
public class GradeService {

    /** {@link JpaGradeRepository}. */
    @Autowired
    private JpaGradeRepository gradeRepository;

    /**
     * Try to save two grades of a student.
     * @param grades Grades to save
     */
    @Transactional
    public void saveGrades(List<Grade> grades) {
        this.gradeRepository.saveAll(grades);
        throw new FakeErrorException("Error saving student's grades ".concat(grades.get(0).getStudent().toString()));
    }

    /**
     * Save one grade for a student. This method has no defined propagation and isolation.
     * @param grade Grade to save
     */
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_UNCOMMITTED)
    public void save(Grade grade) {
        this.gradeRepository.save(grade);
    }

}
