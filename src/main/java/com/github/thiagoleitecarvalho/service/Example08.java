package com.github.thiagoleitecarvalho.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.github.thiagoleitecarvalho.entity.Student;
import com.github.thiagoleitecarvalho.util.EntityUtils;

/**
 * Business class for the Example8. Creating a transaction with Isolation.READ_COMMITED.
 * @author Thiago Leite e Carvalho
 * @see My linkedIn profile: https://www.linkedin.com/in/thiago-leite-e-carvalho-1b337b127/
 */
@Service
public class Example08 {

    /**
     * Log.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Example08.class);

    /** {@link StudentService}. */
    @Autowired
    private StudentService studentService;

    /** {@link SearchService}. */
    @Autowired
    private SearchService searchService;

    /**
     * Student to save.
     */
    private Student student;

    /**
     * Runs the Example08.
     */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void execute() {

        this.student = EntityUtils.createStudent();

        LOGGER.info("---------------------");
        LOGGER.info("Example 8 started");

        LOGGER.info("Saving the student ".concat(this.student.toString()));
        this.studentService.save(this.student);

        LOGGER.info("At this time, the student won't be found.");
        this.searchService.findStudentByRegistrationNumber(this.student.getRegistrationNumber());
    }

    /**
     * Results for Example08.
     */
    public void showResults() {

        LOGGER.info("Showing the saved student after commit.");
        this.searchService.findStudentByRegistrationNumber(this.student.getRegistrationNumber());

        LOGGER.info("Example 8 ended.");
    }

}
