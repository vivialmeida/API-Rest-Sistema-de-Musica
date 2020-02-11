package br.com.lpweb.sistemaDeMusica.service.Interfaces;
import br.com.lpweb.sistemaDeMusica.model.Artista;

import java.util.List;
import java.util.Optional;

public interface IArtistaService {

       List<Artista> recuperaArtistas();

       Artista recuperaArtistaPor(Integer id);

      List<Artista> recuperaArtistaPorNacionalidade(String nacionalidade);

       List<Artista> recuperaArtistaPorNome(String nacionalidade);

       void insereArtista(Artista artista);

       void excluiArtistaPor(Integer id);

       Artista atualizaArtista(Artista artista,Integer id);
}
