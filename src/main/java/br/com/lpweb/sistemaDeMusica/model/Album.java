package br.com.lpweb.sistemaDeMusica.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "album")
public class Album {
      @Id @GeneratedValue
      Integer id;
      String nome;
      Integer ano;
      @OneToMany
      List<Artista> participantes;
      @OneToMany
      List<Musica> musicas;


}
