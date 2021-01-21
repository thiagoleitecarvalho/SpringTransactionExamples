package com.github.thiagoleitecarvalho.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.github.thiagoleitecarvalho.entity.Student;
import com.github.thiagoleitecarvalho.service.SearchService;
import com.github.thiagoleitecarvalho.service.StudentService;
import com.github.thiagoleitecarvalho.util.EntityUtils;

/**
 * Business class for the Example11. Creating a transaction with Isolation.SERIALIZABLE.
 * @author Thiago Leite e Carvalho
 * @see My linkedIn profile: https://www.linkedin.com/in/thiago-leite-e-carvalho-1b337b127/
 */
@Component
public class Example11 {

    /**
     * Log.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Example11.class);

    /** {@link StudentService}. */
    @Autowired
    private StudentService studentService;

    /** {@link SearchService}. */
    @Autowired
    private SearchService searchService;

    /**
     * Runs the Example11.
     */
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void execute() {

        LOGGER.info("---------------------");
        LOGGER.info("Example 11 started -> Isolation.SERIALIZABLE");

        LOGGER.info("Showing the saved students.");
        this.searchService.listAllStudents();

        // Student to save.
        Student student = EntityUtils.createStudent();

        LOGGER.info("Saving a new student a new transaction: ".concat(student.toString()));
        this.studentService.saveRequiredNew(student);

        LOGGER.info("Showing the saved students.");
        this.searchService.listAllStudents();

        LOGGER.info("Example 11 finished");
    }
}
