package com.github.thiagoleitecarvalho.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.stereotype.Service;

import com.github.thiagoleitecarvalho.example.Example01;
import com.github.thiagoleitecarvalho.example.Example02;
import com.github.thiagoleitecarvalho.example.Example04;
import com.github.thiagoleitecarvalho.example.Example05;
import com.github.thiagoleitecarvalho.example.Example06;
import com.github.thiagoleitecarvalho.example.Example07;
import com.github.thiagoleitecarvalho.example.Example08;
import com.github.thiagoleitecarvalho.example.Example09;
import com.github.thiagoleitecarvalho.example.Example10;
import com.github.thiagoleitecarvalho.example.Example11;
import com.github.thiagoleitecarvalho.example.Example12;
import com.github.thiagoleitecarvalho.exception.FakeErrorException;

/**
 * Facade class for all Examples.
 * @author Thiago Leite e Carvalho
 * @see My linkedIn profile: https://www.linkedin.com/in/thiago-leite-e-carvalho-1b337b127/
 */
@Service
public class ExamplesFacade {

    /**
     * Log.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExamplesFacade.class);

    /** {@link Example01}. */
    @Autowired
    private Example01 example01;

    /** {@link Example02}. */
    @Autowired
    private Example02 example02;

    /** {@link Example04}. */
    @Autowired
    private Example04 example04;

    /** {@link Example05}. */
    @Autowired
    private Example05 example05;

    /** {@link Example06}. */
    @Autowired
    private Example06 example06;

    /** {@link Example07}. */
    @Autowired
    private Example07 example07;

    /** {@link Example08}. */
    @Autowired
    private Example08 example08;

    /** {@link Example09}. */
    @Autowired
    private Example09 example09;

    /** {@link Example10}. */
    @Autowired
    private Example10 example10;

    /** {@link Exemple11}. */
    @Autowired
    private Example11 example11;

    /** {@link Example12}. */
    @Autowired
    private Example12 example12;

    /**
     * Run all of the examples of transactions.
     */
    public void runAll() {

        LOGGER.info("#####################");
        LOGGER.info("Running all examples.");

        try {

            this.example01.execute();
        } catch (FakeErrorException e) {
            this.example01.showResults();
        }

        this.example02.execute();

        this.example04.execute();

        this.example05.execute();
        this.example05.showResults();

        try {

            this.example06.execute();
        } catch (FakeErrorException e) {
            this.example06.showResults();
        }

        this.example07.execute();
        this.example07.showResults();

        this.example08.execute();
        this.example08.showResults();

        this.example09.execute();

        try {
            this.example10.execute();
        } catch (CannotAcquireLockException e) {
            e.printStackTrace();
            LOGGER.info("Example 10 finished");
        }

        this.example11.execute();

        this.example12.execute();
        this.example12.showResults();

        LOGGER.info("All examples finished.");
        LOGGER.info("#####################");
    }

}
