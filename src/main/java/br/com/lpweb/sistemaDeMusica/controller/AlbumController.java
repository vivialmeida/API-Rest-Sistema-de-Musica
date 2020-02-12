package br.com.lpweb.sistemaDeMusica.controller;


import br.com.lpweb.sistemaDeMusica.model.Album;
import br.com.lpweb.sistemaDeMusica.repository.filtro.AlbumFiltro;
import br.com.lpweb.sistemaDeMusica.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;


@RestController
@RequestMapping("/albuns")
public class AlbumController {

      private AlbumService albumService;

      @Autowired
      public AlbumController(AlbumService albumService) {
            this.albumService = albumService;
      }


      @GetMapping
      public ResponseEntity busca(AlbumFiltro filtro, Pageable page  ) {
             return ResponseEntity.ok().body(albumService.busca(filtro, page ));
      }

//      @GetMapping("/{id}")
//      public ResponseEntity buscaAlbumPor(@PathVariable Integer id){
//            return ResponseEntity.ok().body(albumService.recuperaAlbumPor(id));
//      }


//      @GetMapping("/album")
//      public ResponseEntity buscaAlbumPor(@RequestParam("album") String album) throws ValidationException {
//            return ResponseEntity.ok().body(albumService.ArtistaPorAlbum(album));
//      }


      @PostMapping
      public ResponseEntity InsereAlbuns(@RequestBody Album album){
            albumService.insereAlbum(album);
            return ResponseEntity.ok().body(albumService.recuperaAlbuns());
      }


      @DeleteMapping("/{id}")
      public ResponseEntity excluiAlbunmPor(@PathVariable Integer id){
            albumService.excluiAlbumPor(id);
            return ResponseEntity.status(HttpStatus.OK).build();
      }

      @PutMapping("/{id}")
      public ResponseEntity atualizaAlbum(@PathVariable Integer id, @RequestBody Album album){
            return ResponseEntity.ok().body(albumService.atualizaAlbum(album, id));
      }


}
