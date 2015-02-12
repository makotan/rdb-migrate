package com.makotan.tools.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * User: makotan
 * Date: 15/02/07
 * Time: 15:41
 */
public class RmException extends RuntimeException {
    private Throwable cause;

    public RmException() {
        super();
    }

    public RmException(String message) {
        super(message);
    }

    public RmException(String message, Throwable cause) {
        super(message, cause);
        this.cause = cause;
    }

    public RmException(Throwable cause) {
        super(cause);
        this.cause = cause;
    }

    public String getMessage() {
        if (super.getMessage() != null) {
            return super.getMessage();
        } else {
            return cause.getMessage();
        }
    }

    public String getLocalizedMessage() {
        if (super.getLocalizedMessage() != null) {
            return super.getLocalizedMessage();
        } else {
            return cause.getLocalizedMessage();
        }
    }

    public synchronized Throwable getCause() {
        return (cause == null) ? super.getCause() : cause;
    }

    public String toString() {
        if (super.getMessage() != null) {
            return super.toString();
        } else {
            return cause.toString();
        }
    }

    public void printStackTrace() {
        if (cause == null) {
            super.printStackTrace();
        } else {
            cause.printStackTrace();
        }
    }

    public void printStackTrace(PrintStream s) {
        if (cause == null) {
            super.printStackTrace(s);
        } else {
            cause.printStackTrace(s);
        }
    }

    public void printStackTrace(PrintWriter s) {
        if (cause == null) {
            super.printStackTrace(s);
        } else {
            cause.printStackTrace(s);
        }
    }
    public synchronized Throwable fillInStackTrace() {
        if (cause == null) {
            return super.fillInStackTrace();
        } else {
            return cause.fillInStackTrace();
        }
    }

    public StackTraceElement[] getStackTrace() {
        if (cause == null) {
            return super.getStackTrace();
        } else {
            return cause.getStackTrace();
        }
    }


}
