package com.yousyuukai.presto.api.controller;

import com.yousyuukai.presto.api.exception.ValidationException;
import org.slf4j.Logger;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

public class BaseController {

    protected void validationHandler(BindingResult errors, Logger logger) throws ValidationException {
        List<String> errorList = new ArrayList<String>();
        if (errors.hasErrors()) {
            errors.getFieldErrors().stream().forEach(e -> {
                logger.error(e.toString());
                errorList.add(e.toString());
            });
            throw new ValidationException(errorList);
        }
    }


}
