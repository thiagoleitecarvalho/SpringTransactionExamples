package com.github.thiagoleitecarvalho.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.thiagoleitecarvalho.entity.Grade;
import com.github.thiagoleitecarvalho.entity.Student;
import com.github.thiagoleitecarvalho.service.GradeService;
import com.github.thiagoleitecarvalho.service.SearchService;
import com.github.thiagoleitecarvalho.service.StudentService;

/**
 * Business class for the Example12. Creating a transaction with Propagation.REQUIRES_NEW and Isolation.READ_UNCOMMITED.
 * @author Thiago Leite e Carvalho
 * @see My linkedIn profile: https://www.linkedin.com/in/thiago-leite-e-carvalho-1b337b127/
 */
@Component
public class Example12 {

    /**
     * Log.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Example12.class);

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
     * Runs the Example12.
     */
    @Transactional
    public void execute() {

        LOGGER.info("---------------------");
        LOGGER.info("Example 12 started -> Propagation.REQUIRES_NEW and Isolation.READ_UNCOMMITED");

        this.student = new Student();
        this.student.setName("Fake");
        this.student.setRegistrationNumber("11111111-1");

        Grade grade = new Grade();
        grade.setDiscipline("OS");
        grade.setGrade(6.5);
        grade.setStudent(this.student);

        LOGGER.info("Saving the new student ".concat(this.student.toString()));
        this.studentService.save(this.student);

        LOGGER.info("Saving student's grade ".concat(grade.toString()));
        this.gradeService.save(grade);

    }

    /**
     * Results for Example12.
     */
    public void showResults() {

        LOGGER.info("Showing the saved student and your grades.");
        this.searchService.findStudentByRegistrationNumber(this.student.getRegistrationNumber());
        this.searchService.listAllStudentsGrade(this.student);

        LOGGER.info("Example 12 finished");
    }
}
