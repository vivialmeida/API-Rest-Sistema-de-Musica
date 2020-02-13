package br.com.lpweb.sistemaDeMusica.service;

import br.com.lpweb.sistemaDeMusica.model.Album;
import br.com.lpweb.sistemaDeMusica.model.AlbumDTO;
import br.com.lpweb.sistemaDeMusica.model.Artista;
import br.com.lpweb.sistemaDeMusica.repository.IAlbumRepository;
import br.com.lpweb.sistemaDeMusica.repository.filtro.AlbumFiltro;
import br.com.lpweb.sistemaDeMusica.service.exception.MusicaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class AlbumService {

      private final GenericoService<Album> genericoService;

      private final IAlbumRepository albumRepository;


      @Autowired
      AlbumService(IAlbumRepository albumRepository) {
            this.albumRepository = albumRepository;
            this.genericoService = new GenericoService<>(albumRepository);
      }


      @Transactional(readOnly = true)
      public Page<Album> busca(AlbumFiltro filtro, Pageable pageable) {
            return albumRepository.filtrar(filtro, pageable );
      }

      @Transactional(readOnly = true)
      public List<Album> recuperaAlbuns() {
         List<Album> albuns = genericoService.todos();
         if(albuns ==  null || albuns.isEmpty()  ){
               new MusicaException("Nenhum album cadastrado");
         }
            return albuns;
      }


      @Transactional(readOnly = true)
      public Album recuperaAlbumPor(Integer id) {
            Album album = genericoService.buscaPor(id);
            if(album == null){
                  new MusicaException("Album nao encontrado");
            }
            return album;
      }


      @Transactional
      public void insereAlbum(Album album) {
            if(album == null){
                  new MusicaException("Album invalido");
            }
            genericoService.salva(album);
      }


      @Transactional
      public void excluiAlbumPor(Integer id) {
            genericoService.excluirPor(id);
      }

      @Transactional
      public Album atualizaAlbum(Album album, Integer id) {
            if(album == null){
                  new MusicaException("Album invalido");
            }
           return genericoService.atualiza(album, id);
      }

      public AlbumDTO fromDTO(Album album){
            if(album == null){
                  new MusicaException("Album invalido");
            }
            return  AlbumDTO.builder()
                    .nome(album.getNome())
                    .ano(album.getAno()).build();

      }

}
