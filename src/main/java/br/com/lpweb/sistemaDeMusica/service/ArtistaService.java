package br.com.lpweb.sistemaDeMusica.service;

import br.com.lpweb.sistemaDeMusica.model.Album;
import br.com.lpweb.sistemaDeMusica.model.Artista;
import br.com.lpweb.sistemaDeMusica.repository.IArtistaRepository;
import br.com.lpweb.sistemaDeMusica.service.Interfaces.IArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArtistaService extends GenericoService implements IArtistaService {

      @Autowired
      ArtistaService(@Qualifier("IArtistaRepository") JpaRepository repository) {
            super(repository);
      }

      @Transactional(readOnly = true)
      public List<Artista> recuperaArtistas(){
          return  this.todos();
      }

      @Transactional(readOnly = true)
      public Artista recuperaArtistaPor(Integer id){
            return (Artista) this.buscaPor(id);

      }
      @Transactional
      public void insereArtista(Artista artista){
            this.salva(artista);
      }

      public void excluiArtistaPor(Integer id){
            this.excluirPor(id);
      }

      @Transactional
      public Artista atualizaArtista( Artista artista, Integer id){
           return (Artista) this.atualiza(artista, id);
      }


}
