package br.com.lpweb.sistemaDeMusica.model.handler;

import lombok.*;

import java.io.Serializable;

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
}