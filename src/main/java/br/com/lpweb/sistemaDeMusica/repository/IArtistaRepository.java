package br.com.lpweb.sistemaDeMusica.repository;

import br.com.lpweb.sistemaDeMusica.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IArtistaRepository extends JpaRepository<Artista, Integer> {

        Optional <List<Artista>>findByNacionalidade(String nacionalidade);

        Optional<List<Artista>> findByNome(String nome);

}
