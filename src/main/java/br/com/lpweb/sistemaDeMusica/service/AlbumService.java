package br.com.lpweb.sistemaDeMusica.service;

import br.com.lpweb.sistemaDeMusica.model.Album;
import br.com.lpweb.sistemaDeMusica.repository.IAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

      private IAlbumRepository albumRepository;

      @Autowired
      public AlbumService(IAlbumRepository albumRepository) {
            this.albumRepository = albumRepository;
      }


      public List<Album>recuperaAlbuns(){
            return  null;
      }


     public Album recuperaAlbumPor(Integer id){
           return  null;

     }

      public void insereAlbum(Integer id){

      }

      public void excluiAlbum(Integer id){

      }

      public Album atualizaAlbum(Integer id){
            return null;
      }





}
