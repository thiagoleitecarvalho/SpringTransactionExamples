package com.github.thiagoleitecarvalho.exception;

/**
 * Auxiliary exception for use in sample transactions.
 * @author Thiago Leite e Carvalho
 * @see My linkedIn profile: https://www.linkedin.com/in/thiago-leite-e-carvalho-1b337b127/
 */
public class FakeErrorException extends RuntimeException {

    /**
     * Serial id.
     */
    private static final long serialVersionUID = -5838375368005171707L;

    /**
     * Constructor.
     * @param message Message error
     */
    public FakeErrorException(String message) {
        super(message);
    }

}
