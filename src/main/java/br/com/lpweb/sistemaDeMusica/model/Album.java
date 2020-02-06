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

//      @ManyToMany
//      @Column(name = "musicas")
//      List<Musica> musicas;
//
//      @ManyToMany
//      @Column(name = "artistas")
//      List<Artista> participantes;
//
//      @ManyToMany(mappedBy = "albums")
//      @Column(name = "artistas")
//      List<Artista> interpretes;





}
