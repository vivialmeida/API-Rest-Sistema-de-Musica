package br.com.lpweb.sistemaDeMusica.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "album")
public class Album {
      @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "album_id")
      Integer id;
      @Column(name = "nome")
      String nome;
      @Column(name = "ano")
      Integer ano;
//      @OneToMany
//      @Column(name = "participantes")
//      List<Artista> participantes;
//      @OneToMany
//      @Column(name = "musicas")
//      List<Musica> musicas;


}
