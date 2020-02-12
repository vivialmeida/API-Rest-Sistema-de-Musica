package br.com.lpweb.sistemaDeMusica.service;

import br.com.lpweb.sistemaDeMusica.model.Musica;
import br.com.lpweb.sistemaDeMusica.repository.IMusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MusicaService  {


      GenericoService<Musica> genericoService;

      private final IMusicaRepository musicaRepository;

      @Autowired
      MusicaService(IMusicaRepository musicaRepository) {
            this.musicaRepository = musicaRepository;
            this.genericoService = new GenericoService<Musica>(musicaRepository);
      }


      @Transactional(readOnly = true)
      public List<Musica> recuperaMusicas() {
           return genericoService.todos();
      }


      @Transactional(readOnly = true)
      public Musica recuperaMusicaPor(Integer id) {
            return (Musica) genericoService.buscaPor(id);
      }


      @Transactional
      public void insereMusica(Musica musica) {
            genericoService.salva(musica);
      }


      @Transactional
      public void excluiMusicaPor(Integer id) {
            genericoService.excluirPor(id);
      }


      @Transactional
      public Musica atualizaMusica(Musica musica , Integer id) {
           return (Musica) genericoService.atualiza(musica, id);
      }


}
