package com.github.thiagoleitecarvalho.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.thiagoleitecarvalho.entity.Student;
import com.github.thiagoleitecarvalho.service.SearchService;
import com.github.thiagoleitecarvalho.service.StudentService;
import com.github.thiagoleitecarvalho.util.EntityUtils;

/**
 * Business class for the Example7. Creating a transaction with Propagation.SUPPORTS
 * @author Thiago Leite e Carvalho
 * @see My linkedIn profile: https://www.linkedin.com/in/thiago-leite-e-carvalho-1b337b127/
 */
@Component
public class Example07 {

    /**
     * Log.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Example07.class);

    /** {@link StudentService}. */
    @Autowired
    private StudentService studentService;

    /** {@link SearchService}. */
    @Autowired
    private SearchService searchService;

    /**
     * Runs the Example07.
     */
    public void execute() {

        LOGGER.info("---------------------");
        LOGGER.info("Example 7 started");

        executeWithoutTransaction();
        executeWithTransaction();
    }

    protected void executeWithoutTransaction() {

        // Student to save.
        Student student = EntityUtils.createStudent();

        LOGGER.info("Saving the student ".concat(student.toString()));
        this.studentService.saveSupports(student);
    }

    @Transactional
    protected void executeWithTransaction() {

        // Student to save.
        Student student = EntityUtils.createStudent();

        LOGGER.info("Saving the student ".concat(student.toString()));
        this.studentService.saveSupports(student);

    }

    /**
     * Results for Example07.
     */
    public void showResults() {

        LOGGER.info("Showing the saved students");
        this.searchService.listAllStudents();

        LOGGER.info("Example 7 ended.");
    }
}
