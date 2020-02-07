package com.codeup.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ReportException extends Exception {

    public ReportException() {
        super("Report not found");
    }
}
