package br.com.lpweb.sistemaDeMusica.service;

import br.com.lpweb.sistemaDeMusica.model.Musica;
import br.com.lpweb.sistemaDeMusica.repository.IMusicaRepository;
import br.com.lpweb.sistemaDeMusica.service.Interfaces.IMusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MusicaService implements IMusicaService{


      GenericoService<Musica> genericoService;

      private final IMusicaRepository musicaRepository;

      @Autowired
      MusicaService(IMusicaRepository musicaRepository) {
            this.musicaRepository = musicaRepository;
            this.genericoService = new GenericoService<Musica>(musicaRepository);
      }


      @Override
      @Transactional(readOnly = true)
      public List<Musica> recuperaMusicas() {
           return genericoService.todos();
      }

      @Override
      @Transactional(readOnly = true)
      public Musica recuperaMusicaPor(Integer id) {
            return (Musica) genericoService.buscaPor(id);
      }

      @Override
      @Transactional
      public void insereMusica(Musica musica) {
            genericoService.salva(musica);
      }

      @Override
      @Transactional
      public void excluiMusicaPor(Integer id) {
            genericoService.excluirPor(id);
      }

      @Override
      @Transactional
      public Musica atualizaMusica(Musica musica , Integer id) {
           return (Musica) genericoService.atualiza(musica, id);
      }

//      @Transactional(readOnly = true)
//      public Page<Musica> busca(MusicaFiltro filtro, Pageable pageable) {
//            return musicaRepository.filtrar(filtro, pageable );
//      }

}
