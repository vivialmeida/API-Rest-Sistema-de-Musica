package br.com.lpweb.sistemaDeMusica.service;

import br.com.lpweb.sistemaDeMusica.model.Album;
import br.com.lpweb.sistemaDeMusica.model.AlbumDTO;
import br.com.lpweb.sistemaDeMusica.model.Artista;
import br.com.lpweb.sistemaDeMusica.repository.IAlbumRepository;
import br.com.lpweb.sistemaDeMusica.repository.filtro.AlbumFiltro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
          return genericoService.todos();
      }

//      @Transactional(readOnly = true)
//      public List<AlbumDTO> ArtistaPorAlbum(String paticipante) throws ValidationException {
//
//           List<Album> albuns= albumRepository.findAlbumByParticipantes(paticipante);
//           if (albuns.isEmpty()){
//                 throw  new ValidationException("Esse Artista nao tem participacao em nenhum album! ");
//           }
//
//           List<AlbumDTO> dto = new ArrayList<>();
//            for (Album album: albuns){
//                  dto.add(fromDTO(album));
//            }
//           return dto;
//      }


      @Transactional(readOnly = true)
      public Album recuperaAlbumPor(Integer id) {
            return genericoService.buscaPor(id);
      }


      @Transactional
      public void insereAlbum(Album album) {
            genericoService.salva(album);
      }


      @Transactional
      public void excluiAlbumPor(Integer id) {
            genericoService.excluirPor(id);
      }

      @Transactional
      public Album atualizaAlbum(Album album, Integer id) {
           return (Album) genericoService.atualiza(album, id);
      }

      public AlbumDTO fromDTO(Album album){
            return  AlbumDTO.builder()
                    .nome(album.getNome())
                    .ano(album.getAno()).build();

      }
}
