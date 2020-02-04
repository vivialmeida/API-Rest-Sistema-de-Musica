package br.com.lpweb.sistemaDeMusica.service;
import br.com.lpweb.sistemaDeMusica.model.Musica;
import br.com.lpweb.sistemaDeMusica.repository.IMusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {
      private IMusicaRepository musicaRepository;

      @Autowired
      public MusicaService(IMusicaRepository artistaRepositorya) {
            this.musicaRepository = musicaRepository;
      }


      public List<Musica> recuperaMusicas(){
            return  null;
      }


      public Musica recuperaMusicaPor(Integer id){
            return  null;

      }

      public void insereMusica(Integer id){

      }

      public void excluiMusica(Integer id){

      }

      public Musica atualizaMusica(Integer id){
            return null;
      }


}
