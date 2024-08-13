package com.example.accounts_demo.exception;

import com.example.accounts_demo.dto.ErrorResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        HashMap<String,String> validationErrors = new HashMap<>();
        List<ObjectError> errors = ex
                .getBindingResult()
                .getAllErrors();
        errors.forEach(error->{
            String fieldName = ((FieldError)error).getField();
            String validationMsg = error.getDefaultMessage();
            validationErrors.put(fieldName,validationMsg);
        });
//        return this.handleExceptionInternal(ex,validationErrors, headers, status, request);
        return new ResponseEntity<>(validationErrors,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponseDto> handleCustomerAlredyExistException(CustomerAlreadyExistsException exception, WebRequest webRequest){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                exception.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponseDto> handleResourceotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
      ErrorResponseDto errorResponseDto = new ErrorResponseDto(
              webRequest.getDescription(false),
              exception.getMessage(),
              HttpStatus.NOT_FOUND,
              LocalDateTime.now()
      );

      return new ResponseEntity<>(errorResponseDto,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception exception, WebRequest webRequest){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now()
        );

        return new ResponseEntity<>(errorResponseDto,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
