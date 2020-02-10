package br.com.lpweb.sistemaDeMusica.service;

import br.com.lpweb.sistemaDeMusica.model.Musica;
import br.com.lpweb.sistemaDeMusica.repository.filtro.MusicaFiltro;
import br.com.lpweb.sistemaDeMusica.repository.musica.MusicaRepositoryImpl;
import br.com.lpweb.sistemaDeMusica.repository.musica.MusicaRepositoryQuery;
import br.com.lpweb.sistemaDeMusica.service.Interfaces.IMusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class MusicaService extends  GenericoService implements IMusicaService {


      private MusicaRepositoryImpl musicaRepository = new MusicaRepositoryImpl();

      @Autowired
      MusicaService(JpaRepository<Musica, Integer> repository) {
            super(repository);
      }



      @Override
      @Transactional(readOnly = true)
      public List<Musica> recuperaMusicas() {
           return this.todos();
      }

      @Override
      @Transactional(readOnly = true)
      public Musica recuperaMusicaPor(Integer id) {
            return (Musica) this.buscaPor(id);
      }

      @Override
      @Transactional
      public void insereMusica(Musica musica) {
            this.salva(musica);
      }

      @Override
      @Transactional
      public void excluiMusicaPor(Integer id) {
            this.excluirPor(id);
      }

      @Override
      @Transactional
      public Musica atualizaMusica(Musica musica , Integer id) {
           return (Musica) this.atualiza(musica, id);
      }

      @Transactional(readOnly = true)
      public Page<Musica> busca(MusicaFiltro filtro, Pageable pageable) {
            return musicaRepository.filtrar(filtro, pageable );
      }

}
