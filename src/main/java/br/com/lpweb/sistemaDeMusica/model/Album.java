package br.com.lpweb.sistemaDeMusica.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "albuns")
public class Album {
      @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "album_id")
      Integer id;
      String nome;
      Integer ano;

      @ManyToMany
      @JoinTable( name = "album_musica",
      joinColumns = @JoinColumn(name = "id_album"),
          inverseJoinColumns = @JoinColumn(name = "id_musica"))
      List<Musica> musicas;

      @ManyToMany
      List<Artista> participantes;

}
