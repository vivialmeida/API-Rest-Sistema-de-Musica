package br.com.lpweb.sistemaDeMusica.service.Interfaces;
import br.com.lpweb.sistemaDeMusica.model.Artista;

import java.util.List;

public interface IArtistaService {

       List<Artista> recuperaArtistas();

       Artista recuperaArtistaPor(Integer id);

       void insereArtista(Artista artista);

       void excluiArtistaPor(Integer id);

       Artista atualizaArtista(Integer id);
}
