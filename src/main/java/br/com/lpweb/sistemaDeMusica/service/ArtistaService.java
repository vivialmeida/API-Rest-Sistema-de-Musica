package br.com.lpweb.sistemaDeMusica.service;

import br.com.lpweb.sistemaDeMusica.model.Album;
import br.com.lpweb.sistemaDeMusica.model.Artista;
import br.com.lpweb.sistemaDeMusica.repository.IArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaService {

      private IArtistaRepository  artistaRepository;

      @Autowired
      public ArtistaService(IArtistaRepository artistaRepositorya) {
            this.artistaRepository = artistaRepositorya;
      }


      public List<Album> recuperaArtistas(){
            return  null;
      }


      public Artista recuperaArtistaPor(Integer id){
            return  null;

      }

      public void insereAlbum(Integer id){

      }

      public void excluiAlbum(Integer id){

      }

      public Artista atualizaArtista(Integer id){
            return null;
      }



}
