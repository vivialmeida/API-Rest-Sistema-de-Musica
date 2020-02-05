package br.com.lpweb.sistemaDeMusica.service;

import br.com.lpweb.sistemaDeMusica.model.Musica;
import br.com.lpweb.sistemaDeMusica.service.Interfaces.IMusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService extends  GenericoService implements IMusicaService {

      @Autowired
      MusicaService(JpaRepository<Musica, Integer> repository) {
            super(repository);
      }


      @Override
      public List<Musica> recuperaMusicas() {
           return this.todos();
      }

      @Override
      public Musica recuperaMusicaPor(Integer id) {
            return (Musica) this.buscaPor(id);
      }

      @Override
      public void insereMusica(Musica musica) {
            this.salva(musica);

      }

      @Override
      public void excluiMusicaPor(Integer id) {
            this.excluirPor(id);
      }

      @Override
      public Musica atualizaMusica(Integer id) {
           return (Musica) this.atualiza(Musica.class, id);
      }

}
