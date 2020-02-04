package br.com.lpweb.sistemaDeMusica.repository;

import br.com.lpweb.sistemaDeMusica.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArtistaRepository extends JpaRepository<Artista, Integer> {

}
