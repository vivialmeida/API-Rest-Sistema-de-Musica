package br.com.lpweb.sistemaDeMusica.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;


@Data
@Entity
@Table(name = "musica")
public class Musica {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "musica_id")
      Integer id;

      @Column(name = "nome")
      String nome;

      @Column(name = "duracao")
      Time duracao;

      @ManyToMany
      @Column(name = "musicas_autores")
      List<Artista> artistas;

      @ManyToMany(mappedBy = "musicas")
      List<Album> albums;


}
