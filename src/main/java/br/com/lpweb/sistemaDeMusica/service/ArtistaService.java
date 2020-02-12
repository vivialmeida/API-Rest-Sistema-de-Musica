package br.com.lpweb.sistemaDeMusica.service;

import br.com.lpweb.sistemaDeMusica.model.Album;
import br.com.lpweb.sistemaDeMusica.model.Artista;
import br.com.lpweb.sistemaDeMusica.model.AlbumDTO;
import br.com.lpweb.sistemaDeMusica.repository.IArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.ValidationException;
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
          return  genericoService.todos();
      }

      @Transactional(readOnly = true)
      public Optional<List<Artista>> recuperaArtistaPorNome(String nome){
            return artistaRepository.findByNome(nome);
      }

      @Transactional(readOnly = true)
      public Optional<List<Artista>>recuperaArtistaPorNacionalidade(String nacionalidade){
            System.out.println(nacionalidade);
            return artistaRepository.findByNacionalidade(nacionalidade);
      }

      @Transactional(readOnly = true)
      public Artista recuperaArtistaPor(Integer id){
            return genericoService.buscaPor(id);
      }

      @Transactional
      public void insereArtista(Artista artista){
            genericoService.salva(artista);
      }

      public void excluiArtistaPor(Integer id){
            genericoService.excluirPor(id);
      }

      @Transactional
      public Artista atualizaArtista( Artista artista, Integer id){
           return genericoService.atualiza(artista, id);
      }



}
