package com.github.thiagoleitecarvalho.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.thiagoleitecarvalho.entity.Student;
import com.github.thiagoleitecarvalho.exception.FakeErrorException;
import com.github.thiagoleitecarvalho.service.SearchService;
import com.github.thiagoleitecarvalho.service.StudentService;
import com.github.thiagoleitecarvalho.util.EntityUtils;

/**
 * Business class for the Example5. Creating a transaction with Propagation.NOT_SUPPORTED.
 * @author Thiago Leite e Carvalho
 * @see My linkedIn profile: https://www.linkedin.com/in/thiago-leite-e-carvalho-1b337b127/
 */
@Component
public class Example05 {

    /**
     * Log.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Example05.class);

    /** {@link StudentService}. */
    @Autowired
    private StudentService studentService;

    /** {@link SearchService}. */
    @Autowired
    private SearchService searchService;

    /**
     * Runs the Example05.
     */
    @Transactional
    public void execute() {

        // Students to save.
        Student student1 = EntityUtils.createStudent();
        Student student2 = EntityUtils.createStudent();

        LOGGER.info("---------------------");
        LOGGER.info("Example 5 started");

        try {

            LOGGER.info("Saving the student ".concat(student1.toString()));
            this.studentService.save(student1);

            LOGGER.info("Saving the student ".concat(student2.toString()));
            this.studentService.saveNotSupported(student2);
        } catch (FakeErrorException e) {
            LOGGER.info(e.getMessage());
        }

    }

    /**
     * Results for Example05.
     */
    public void showResults() {

        LOGGER.info("Showing the saved students.");
        this.searchService.listAllStudents();

        LOGGER.info("Example 5 ended.");

    }
}
