//package com.example.springboot.SpringAssignment.exceptions;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class ConsumerExceptionHandler {
//    //add an exception handler
//    @ExceptionHandler
//    public ResponseEntity<ConsumerErrorResponse> handleException (ConsumerNotFoundException e){
//        //create customer error resp obbnj
//        ConsumerErrorResponse error = new ConsumerErrorResponse(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
//
//        //return response entity
//        return  new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
//    }
//    @ExceptionHandler
//    public ResponseEntity<ConsumerErrorResponse> handleException (Exception e){
//        //create customer error resp obbnj
//        ConsumerErrorResponse error = new ConsumerErrorResponse(HttpStatus.BAD_REQUEST.value(),e.getMessage(),System.currentTimeMillis());
//
//        //return response entity
//        return  new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
//    }
//}
