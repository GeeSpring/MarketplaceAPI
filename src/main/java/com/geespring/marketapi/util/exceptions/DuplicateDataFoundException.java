package com.geespring.marketapi.util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.IM_USED)
public class DuplicateDataFoundException extends RuntimeException{
}
