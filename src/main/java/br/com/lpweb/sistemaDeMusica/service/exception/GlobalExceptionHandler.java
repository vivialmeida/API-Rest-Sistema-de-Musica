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
import javax.validation.ConstraintViolationException;
import javax.xml.bind.ValidationException;
import java.sql.SQLException;


//@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StandardError erro = setStandartErro("Recurso não suportado: " + ex.getMessage(), request);
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(erro);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StandardError erro =  setStandartErro("Parâmetro vazio: " + ex.getMessage(), request);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<StandardError> handleAllExceptions(Exception ex, WebRequest request) {
        StandardError erro = setStandartErro( ex.getMessage(), request);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity handlePdvValidationException(ValidationException e, WebRequest request) {
        StandardError erro = setStandartErro( e.getMessage(), request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(MusicaException.class)
    public ResponseEntity musicaException(MusicaException e, WebRequest request) {
        StandardError erro = setStandartErro( e.getMessage(), request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity handleNumberFormat(NumberFormatException e, WebRequest request) {
        StandardError erro =  setStandartErro("Tipo do parâmetro inválido: " + e.getMessage(), request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity handleMethodArgumentTypeMismatchExcpetion(MethodArgumentTypeMismatchException e, WebRequest request) {
        StandardError erro =  setStandartErro("Tipo do parâmetro inválido: " + e.getMessage(), request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity handleInvalidFormat(InvalidFormatException e, WebRequest request) {
        StandardError erro = setStandartErro("Formato inválido" + e.getMessage(), request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity handleSqlException(SQLException e, WebRequest request) {
        StandardError erro = setStandartErro("Erro ao executar a query: " + e.getMessage(), request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity handleNullPointerException(NullPointerException e, WebRequest request)  {
        StandardError erro = setStandartErro("Objeto nulo ou vazio: " + e.getMessage(), request);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }


    private StandardError setStandartErro( String mensagem, WebRequest request){
        return  StandardError.builder()
                .message(mensagem)
                .details(request.getDescription(false)).build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity handleNullPointerException(ConstraintViolationException e, WebRequest request)  {
        StandardError erro = setStandartErro("Erro na Validação dos Campos da Entidade " + e.getConstraintViolations(), request);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }

}