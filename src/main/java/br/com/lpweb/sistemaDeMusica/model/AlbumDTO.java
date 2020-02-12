package br.com.lpweb.sistemaDeMusica.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDTO {

      String nome;
      Integer ano;
}
