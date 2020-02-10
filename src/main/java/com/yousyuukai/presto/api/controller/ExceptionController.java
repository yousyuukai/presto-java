package com.yousyuukai.presto.api.controller;

import com.yousyuukai.presto.api.exception.BaseException;
import com.yousyuukai.presto.api.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;

@ControllerAdvice
public class ExceptionController {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    private final String errLogStr = "RequestURL: {0}, Error message: {1}";

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Object handlerValidationException(HttpServletRequest req, ValidationException e) {
        logger.error(MessageFormat.format(errLogStr, req.getRequestURI(), e.toString()));
        return e.toString();
    }

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object handlerBaseException(HttpServletRequest req, BaseException e) {
        logger.error(MessageFormat.format(errLogStr, req.getRequestURI(), e.getMessage()));
        return e.getMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object defaultErrorHandler(HttpServletRequest req, Exception e) {
        logger.error(MessageFormat.format(errLogStr, req.getRequestURI(), e.getMessage()));
        return e.getMessage();
    }

}
