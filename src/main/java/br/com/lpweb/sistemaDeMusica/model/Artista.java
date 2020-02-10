package br.com.lpweb.sistemaDeMusica.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "artistas")
public class Artista {
      @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "artista_id")
      Integer id;

      String nome;

      String nacionalidade;

      @ManyToMany
      @JoinTable(
          name="autorias",
          joinColumns = @JoinColumn(name = "id_artista"),
          inverseJoinColumns = @JoinColumn(name = "id_musica")
      )

      private List<Musica> autorias;

      @ManyToMany
      @JoinTable(
          name="interpretacoes",
          joinColumns = @JoinColumn(name = "id_artista"),
          inverseJoinColumns = @JoinColumn(name = "id_musica")
      )
      private List<Musica> interpretacoes;

      @ManyToMany
      @JoinTable(
          name="albuns_participantes",
          joinColumns = @JoinColumn(name = "id_artista"),
          inverseJoinColumns = @JoinColumn(name = "id_album")
      )
      private List<Musica> participacoes;



}
