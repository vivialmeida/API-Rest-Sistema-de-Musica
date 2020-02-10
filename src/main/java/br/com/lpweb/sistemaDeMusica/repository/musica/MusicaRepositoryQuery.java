package br.com.lpweb.sistemaDeMusica.repository.musica;

import br.com.lpweb.sistemaDeMusica.model.Musica;
import br.com.lpweb.sistemaDeMusica.repository.filtro.MusicaFiltro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface MusicaRepositoryQuery {

      Page<Musica> filtrar(MusicaFiltro filtro, Pageable pageable);

}
