package br.com.lpweb.sistemaDeMusica.service.Interfaces;
import br.com.lpweb.sistemaDeMusica.model.Album;

import java.util.List;
public interface IAlbumService  {

       List<Album> recuperaAlbuns();

       Album recuperaAlbumPor(Integer id);

       void insereAlbum(Album album);

       void excluiAlbumPor(Integer id);

       Album atualizaAlbum(Album album,Integer id);
}
