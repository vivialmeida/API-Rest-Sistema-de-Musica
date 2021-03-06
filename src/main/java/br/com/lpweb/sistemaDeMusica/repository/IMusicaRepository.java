package br.com.lpweb.sistemaDeMusica.repository;

import br.com.lpweb.sistemaDeMusica.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMusicaRepository extends JpaRepository<Musica, Integer> {


}
