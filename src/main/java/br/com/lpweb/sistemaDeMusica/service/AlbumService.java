package br.com.lpweb.sistemaDeMusica.service;

import br.com.lpweb.sistemaDeMusica.model.Album;
import br.com.lpweb.sistemaDeMusica.model.Musica;
import br.com.lpweb.sistemaDeMusica.service.Interfaces.IAlbumService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlbumService extends  GenericoService implements IAlbumService{


      AlbumService(JpaRepository<Musica, Integer> repository) {
            super(repository);
      }

      @Override
      @Transactional(readOnly = true)
      public List<Album> recuperaAlbuns() {
          return this.todos();
      }

      @Override
      @Transactional(readOnly = true)
      public Album recuperaAlbumPor(Integer id) {
            return (Album) this.buscaPor(id);
      }

      @Override
      @Transactional
      public void insereAlbum(Album album) {
            this.salva(album);
      }

      @Override
      @Transactional
      public void excluiAlbumPor(Integer id) {
                  this.excluirPor(id);
      }

      @Override
      @Transactional
      public Album atualizaAlbum(Album album, Integer id) {
           return (Album) this.atualiza(album, id);
      }
}
