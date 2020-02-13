package br.com.lpweb.sistemaDeMusica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Data
@Entity
@Table(name = "albuns")
public class Album {
      @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "album_id")
      Integer id;
      @NotBlank
      String nome;

      @NotNull
      Integer ano;

      @NotEmpty
      @ManyToMany(cascade = CascadeType.ALL)
      @JoinTable( name = "album_musica",
      joinColumns = @JoinColumn(name = "id_album"),
          inverseJoinColumns = @JoinColumn(name = "id_musica"))
      List<Musica> musicas;

      @NotEmpty
      @ManyToMany (mappedBy = "albums", cascade = CascadeType.ALL)
      @JsonIgnore
      List<Artista> participantes;

      @JsonIgnore
      public Integer getDuracaoTotalAbum(){
           AtomicReference<Integer> duracaoTotal = new AtomicReference<>(new Integer(0));
            musicas.forEach(musica ->
                    duracaoTotal.updateAndGet(v -> v + musica.getDuracao()));
            System.out.println();
            return duracaoTotal.get();
      }



}
