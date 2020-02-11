package br.com.lpweb.sistemaDeMusica.repository.album;


import br.com.lpweb.sistemaDeMusica.model.Album;
import br.com.lpweb.sistemaDeMusica.repository.filtro.AlbumFiltro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlbumRepositoryQuery {

      Page<Album> filtrar(AlbumFiltro filtro, Pageable pageable);

}
