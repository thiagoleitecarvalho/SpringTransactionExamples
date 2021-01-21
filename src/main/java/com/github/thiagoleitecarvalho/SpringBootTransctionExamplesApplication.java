package com.github.thiagoleitecarvalho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.github.thiagoleitecarvalho.facade.ExamplesFacade;

/**
 * Class to run the examples.
 * @author Thiago Leite e Carvalho
 * @see My linkedin profile: https://www.linkedin.com/in/thiago-leite-e-carvalho-1b337b127/.
 */
@SpringBootApplication
public class SpringBootTransctionExamplesApplication {

    /**
     * {@link ExamplesFacade}.
     */
    @Autowired
    private ExamplesFacade examplesFacade;

    /**
     * SpringBoot's main method.
     * @param args Optional arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootTransctionExamplesApplication.class, args);
    }

    /**
     * Listener to start the examples.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void runExamples() {
        this.examplesFacade.runAll();
    }

}
