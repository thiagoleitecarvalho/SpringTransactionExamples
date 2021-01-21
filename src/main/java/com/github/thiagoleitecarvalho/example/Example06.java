package com.github.thiagoleitecarvalho.example;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.thiagoleitecarvalho.entity.Grade;
import com.github.thiagoleitecarvalho.entity.Student;
import com.github.thiagoleitecarvalho.exception.FakeErrorException;
import com.github.thiagoleitecarvalho.service.GradeService;
import com.github.thiagoleitecarvalho.service.SearchService;
import com.github.thiagoleitecarvalho.service.StudentService;
import com.github.thiagoleitecarvalho.util.EntityUtils;

/**
 * Business class for the Example6. Creating a transaction with Propagation.REQUIRES_NEW
 * @author Thiago Leite e Carvalho
 * @see My linkedIn profile: https://www.linkedin.com/in/thiago-leite-e-carvalho-1b337b127/
 */
@Component
public class Example06 {

    /**
     * Log.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Example06.class);

    /** {@link StudentService}. */
    @Autowired
    private StudentService studentService;

    /** {@link GradeService}. */
    @Autowired
    private GradeService gradeService;

    /** {@link SearchService}. */
    @Autowired
    private SearchService searchService;

    /**
     * Student to save.
     */
    private Student student;

    /**
     * Runs the Example06.
     */
    @Transactional
    public void execute() {

        this.student = EntityUtils.createStudent();

        // Student's grades to save.
        List<Grade> grades = EntityUtils.createGrades(this.student);

        try {

            LOGGER.info("---------------------");
            LOGGER.info("Example 6 started");

            LOGGER.info("Saving the student ".concat(this.student.toString()));
            this.studentService.saveRequiredNew(this.student);

            LOGGER.info("Trying to save student's grade ".concat(grades.toString()));
            this.gradeService.saveGrades(grades);
        } catch (FakeErrorException e) {
            LOGGER.error(e.getMessage());
            throw e;
        }

    }

    /**
     * Results for Example06.
     */
    public void showResults() {

        LOGGER.info("Showing the saved student and your grades.");
        this.searchService.findStudentByRegistrationNumber(this.student.getRegistrationNumber());
        this.searchService.listAllStudentsGrade(this.student);

        LOGGER.info("Example 6 ended.");
    }
}
