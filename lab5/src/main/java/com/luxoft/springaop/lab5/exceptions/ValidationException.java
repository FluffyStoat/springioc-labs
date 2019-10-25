package com.luxoft.springaop.lab5.exceptions;

import org.aspectj.lang.annotation.Aspect;

/**
 * @author bochkarev
 * @version $
 */
@Aspect
public class ValidationException extends RuntimeException {
    public ValidationException(String exeption) {

    }
}
