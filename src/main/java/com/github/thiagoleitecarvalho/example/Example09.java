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
 * Business class for the Example9. Creating a transaction with Isolation.READ_UNCOMMITED.
 * @author Thiago Leite e Carvalho
 * @see My linkedIn profile: https://www.linkedin.com/in/thiago-leite-e-carvalho-1b337b127/
 */
@Component
public class Example09 {

    /**
     * Log.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Example09.class);

    /** {@link StudentService}. */
    @Autowired
    private StudentService studentService;

    /** {@link SearchService}. */
    @Autowired
    private SearchService searchService;

    /**
     * Runs for Example09.
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void execute() {

        // Student to save.
        Student student = EntityUtils.createStudent();

        LOGGER.info("---------------------");
        LOGGER.info("Example 9 started -> Isolation.READ_UNCOMMITED");

        LOGGER.info("Saving the student ".concat(student.toString()));
        this.studentService.save(student);

        LOGGER.info("Showing the uncommited student.");
        this.searchService.findStudentByRegistrationNumberWithoutTransaction(student.getRegistrationNumber());

        LOGGER.info("Example 9 ended.");
    }

}
