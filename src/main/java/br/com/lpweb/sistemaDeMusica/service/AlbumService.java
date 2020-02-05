package br.com.lpweb.sistemaDeMusica.service;

import br.com.lpweb.sistemaDeMusica.model.Album;
import br.com.lpweb.sistemaDeMusica.model.Musica;
import br.com.lpweb.sistemaDeMusica.service.Interfaces.IAlbumService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlbumService extends  GenericoService implements IAlbumService{


      AlbumService(JpaRepository<Musica, Integer> repository) {
            super(repository);
      }

      @Override
      public List<Album> recuperaAlbuns() {
          return this.todos();
      }

      @Override
      public Album recuperaAlbumPor(Integer id) {
            return (Album) this.buscaPor(id);
      }

      @Override
      public void insereAlbum(Album album) {
            this.salva(album);
      }

      @Override
      public void excluiAlbumPor(Integer id) {
                  this.excluirPor(id);
      }

      @Override
      public Album atualizaAlbum(Integer id) {
           return (Album) this.atualiza(Album.class, id);
      }
}
