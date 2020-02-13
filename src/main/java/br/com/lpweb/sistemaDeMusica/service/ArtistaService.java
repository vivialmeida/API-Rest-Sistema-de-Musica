package br.com.lpweb.sistemaDeMusica.service;

import br.com.lpweb.sistemaDeMusica.model.Album;
import br.com.lpweb.sistemaDeMusica.model.Artista;
import br.com.lpweb.sistemaDeMusica.model.AlbumDTO;
import br.com.lpweb.sistemaDeMusica.repository.IArtistaRepository;
import br.com.lpweb.sistemaDeMusica.service.exception.MusicaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService {

      GenericoService<Artista> genericoService;

      private IArtistaRepository artistaRepository;

      @Autowired
      ArtistaService(IArtistaRepository artistaRepository) {
            this.artistaRepository = artistaRepository;
            this.genericoService = new GenericoService<Artista>(artistaRepository);
      }
      @Transactional(readOnly = true)
      public List<Artista> recuperaArtistas(){

            List<Artista> artistas =  Optional.ofNullable(genericoService.todos()).orElseThrow(()->
                    new MusicaException("Lista de Artistas invalida")
            );
            if (artistas.isEmpty()){
                  new MusicaException("Não ha nenhum Artista Cadastrado");
            }
            return  artistas;
      }

      @Transactional(readOnly = true)
      public List<Artista> recuperaArtistaPorNome(String nome){
                  List<Artista> artistas =  artistaRepository.findByNome(nome);
          if( artistas.isEmpty()){
                  throw new  MusicaException("Artista " + nome + " nao encontrado!");
            }

          return artistas;
      }

      @Transactional(readOnly = true)
      public List<Artista>recuperaArtistaPorNacionalidade(String nacionalidade){
            List<Artista> artistas = artistaRepository.findByNacionalidade(nacionalidade);
            if(artistas  == null || (artistas.isEmpty())){
                  throw new  MusicaException("Artistas do " + nacionalidade + " nao encontrado!");
            }
            return artistas;
      }

      @Transactional(readOnly = true)
      public Artista recuperaArtistaPor(Integer id){
            Artista artista =  genericoService.buscaPor(id);
            if (artista == null){
                  throw new  MusicaException("Artistas nao encontrado!");
            }
            return artista;
      }

      @Transactional
      public Artista insereArtista(Artista artista){
            if(artista == null ){
                  throw new  MusicaException("Artistas Invalido");
            }
            return genericoService.salva(artista);
      }

      public void excluiArtistaPor(Integer id){
            genericoService.excluirPor(id);
      }

      @Transactional
      public Artista atualizaArtista( Artista artista, Integer id){
            if(artista == null ){
                  throw new  MusicaException("Artista Invalido! ");
            }
           return genericoService.atualiza(artista, id);
      }

}
