package com.joohyeong.global.exception;

import org.springframework.http.HttpStatus;

public interface ErrorCodeType {

    HttpStatus httpStatus();

    String message();

    String errorCode();

}
