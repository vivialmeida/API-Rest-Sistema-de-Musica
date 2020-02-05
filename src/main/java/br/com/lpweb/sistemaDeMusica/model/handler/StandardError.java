package br.com.lpweb.sistemaDeMusica.model.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StandardError implements Serializable {

    private static Long serialVersionUID = 1L;
    int value;
    String message;
    String details;
    @JsonFormat(pattern = "dd/mm/yyyy hh:mm:ss")
    LocalDate currentTimeMillis;
}