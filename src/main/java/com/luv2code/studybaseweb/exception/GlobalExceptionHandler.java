//package com.luv2code.studybaseweb.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.server.ServerErrorException;
//
//import java.time.LocalDateTime;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException nfe) {
//
//        // create the customize respond
//        ErrorResponse errorResponse = new ErrorResponse(
//                HttpStatus.NOT_FOUND.value(),
//                "404 Not Found!",
//                nfe.getMessage(),
//                LocalDateTime.now()
//        );
//
//        // return the response
//        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handleException(Exception e) {
//
//        // create the customize respond
//        ErrorResponse errorResponse = new ErrorResponse(
//                HttpStatus.BAD_REQUEST.value(),
//                "Bad request - invalid formatted!",
//                e.getMessage(),
//                LocalDateTime.now()
//        );
//
//        // return the response
//        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(ServerErrorException.class)
//    public ResponseEntity<ErrorResponse> handleServerError(ServerErrorException e) {
//
//        // create the customize respond
//        ErrorResponse errorResponse = new ErrorResponse(
//                HttpStatus.INTERNAL_SERVER_ERROR.value(),
//                "Something wrong with the server...",
//                e.getMessage(),
//                LocalDateTime.now()
//        );
//
//        // return the response
//        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}
