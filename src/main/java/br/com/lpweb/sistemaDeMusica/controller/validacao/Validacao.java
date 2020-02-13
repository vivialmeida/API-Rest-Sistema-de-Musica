package br.com.lpweb.sistemaDeMusica.controller.validacao;

import br.com.lpweb.sistemaDeMusica.model.handler.StandardError;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class Validacao <T> {

      public List<StandardError> valida(T dto) {

            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Set<ConstraintViolation<T>> validate =
                    validator.validate(dto);

            final List<StandardError> erros = new ArrayList<>();

            validate.forEach(violation ->
            {
                  final String campo = violation.getPropertyPath().toString();

                  erros.add(new StandardError( "Campo: " + violation.getMessage(),
                         "Mensagem:"  + violation.getMessage()));
            });
            return erros;
      }
}