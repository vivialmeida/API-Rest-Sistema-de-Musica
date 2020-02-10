package br.com.lpweb.sistemaDeMusica.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "musicas")
public class Musica {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "musica_id")
      Integer id;

      @Column(name = "nome")
      @NotEmpty
      @NotNull
      String nome;

      @NotNull
      @JsonFormat(pattern = "mm:ss")
      @Column(name = "duracao")
      String duracao;

      @ManyToMany(mappedBy = "interpretacoes")
      @JsonIgnore
      private List<Artista> interpretes;

      @ManyToMany(mappedBy = "autorias")
      @JsonIgnore
      private List<Artista> autores;


      @ManyToMany(mappedBy = "musicas")
      @JsonIgnore
      private List<Album> albuns;

}