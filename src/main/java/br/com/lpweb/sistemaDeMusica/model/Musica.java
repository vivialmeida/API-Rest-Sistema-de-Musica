package br.com.lpweb.sistemaDeMusica.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;


@Data
@Entity
@Table(name = "musica")
public class Musica {
      @Id @GeneratedValue
      Integer id;
      String nome;
      Time time;
      @OneToMany
      List<Artista> autores;
      @OneToMany
      List<Artista> interpretes;


}
