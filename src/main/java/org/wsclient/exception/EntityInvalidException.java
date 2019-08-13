package org.wsclient.exception;

/**
 * 
 * @author George Compton - george.compton@hotmail.com
 * @since 2019.08.12
 *
 */
public final class EntityInvalidException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public EntityInvalidException(String message) {
        super(message);
    }

    public EntityInvalidException(final String message, final Throwable cause) {
        super(message, cause);
    }
}

