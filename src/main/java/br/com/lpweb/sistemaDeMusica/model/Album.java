package br.com.lpweb.sistemaDeMusica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "albuns")
public class Album {
      @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "album_id")
      Integer id;
      @NotEmpty
      String nome;

      @NotNull
      Integer ano;

      @ManyToMany
      @JoinTable( name = "album_musica",
      joinColumns = @JoinColumn(name = "id_album"),
          inverseJoinColumns = @JoinColumn(name = "id_musica"))
      @JsonIgnore
      List<Musica> musicas;

      @ManyToMany
      @JsonIgnore
      List<Artista> participantes;

}
