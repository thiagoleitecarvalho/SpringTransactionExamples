package com.github.thiagoleitecarvalho.example;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.github.thiagoleitecarvalho.entity.Student;
import com.github.thiagoleitecarvalho.service.SearchService;
import com.github.thiagoleitecarvalho.service.StudentService;

/**
 * Business class for the Example10. Creating a transaction with Isolation.REPEATABLE_READ.
 * @author Thiago Leite e Carvalho
 * @see My linkedIn profile: https://www.linkedin.com/in/thiago-leite-e-carvalho-1b337b127/
 */
@Component
public class Example10 {

    /**
     * Log.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Example10.class);

    /** {@link StudentService}. */
    @Autowired
    private StudentService studentService;

    /** {@link SearchService}. */
    @Autowired
    private SearchService searchService;

    /**
     * Runs the Example10.
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void execute() {

        LOGGER.info("---------------------");
        LOGGER.info("Example 10 started -> Isolation.REPEATABLE_READ");

        try {

            LOGGER.info("Showing the saved students.");
            this.searchService.listAllStudents();

            // Student to save.
            List<Student> students = this.searchService.findAllStudents();

            Student student = students.get(0);
            LOGGER.info("Updating the student ".concat(student.toString())
                    .concat(". Changing your registration number to 99999999-9"));
            student.setRegistrationNumber("99999999-9");

            LOGGER.info("Saving the student changed a new transaction.");
            this.studentService.saveRequiredNew(student);

            LOGGER.info("Trying to show the saved students again.");
            this.searchService.findAllStudents();

        } catch (CannotAcquireLockException e) {
            LOGGER.info(e.getMessage());
            throw e;
        }

    }

}
