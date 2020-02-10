package br.com.lpweb.sistemaDeMusica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.sql.Time;
import java.util.List;


@Data
@Entity
@Table(name = "musicas")
public class Musica {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "musica_id")
      Integer id;

      @Column(name = "nome")
      String nome;

      @Column(name = "duracao")

      Time duracao;

      @ManyToMany(mappedBy = "interpretacoes")
      private List<Artista> interpretes ;

      @ManyToMany(mappedBy = "autorias")
      private List<Artista> autores ;

      @JsonIgnore
      @ManyToMany(mappedBy = "musicas")
      private List<Album> albuns;

}
