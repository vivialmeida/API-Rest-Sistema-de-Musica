package br.com.lpweb.sistemaDeMusica.service.exception;

import br.com.lpweb.sistemaDeMusica.model.handler.StandardError;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.PersistenceException;
import javax.xml.bind.ValidationException;
import java.sql.SQLException;
import java.time.LocalDate;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StandardError erro = setStandartErro(HttpStatus.METHOD_NOT_ALLOWED,"Recurso não suportado: " + ex.getMessage(), request);
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(erro);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StandardError erro =  setStandartErro(HttpStatus.NOT_FOUND,"Parâmetro vazio: " + ex.getMessage(), request);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<StandardError> handleAllExceptions(Exception ex, WebRequest request) {
        StandardError erro = setStandartErro(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), request);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity handlePdvValidationException(ValidationException e, WebRequest request) {
        StandardError erro = setStandartErro(HttpStatus.BAD_REQUEST, e.getMessage(), request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity handleNumberFormat(NumberFormatException e, WebRequest request) {
        StandardError erro =  setStandartErro(HttpStatus.BAD_REQUEST,"Tipo do parâmetro inválido: " + e.getMessage(), request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity handleMethodArgumentTypeMismatchExcpetion(MethodArgumentTypeMismatchException e, WebRequest request) {
        StandardError erro =  setStandartErro(HttpStatus.BAD_REQUEST,"Tipo do parâmetro inválido: " + e.getMessage(), request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity handleInvalidFormat(InvalidFormatException e, WebRequest request) {
        StandardError erro = setStandartErro(HttpStatus.BAD_REQUEST,"Formato inválido" + e.getMessage(), request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity handleSqlException(SQLException e, WebRequest request) {
        StandardError erro = setStandartErro(HttpStatus.METHOD_NOT_ALLOWED,"Erro ao executar a query: " + e.getMessage(), request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity handleNullPointerException(NullPointerException e, WebRequest request)  {
        StandardError erro = setStandartErro(HttpStatus.INTERNAL_SERVER_ERROR,"Objeto nulo ou vazio: " + e.getMessage(), request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }



    private StandardError setStandartErro(HttpStatus status, String mensagem, WebRequest request){
        return  StandardError.builder()
                .value(status.value())
                .message(mensagem)
                .details(request.getDescription(false)).build();
    }

}