package br.com.lpweb.sistemaDeMusica.controller;

import br.com.lpweb.sistemaDeMusica.model.Artista;
import br.com.lpweb.sistemaDeMusica.model.Musica;
import br.com.lpweb.sistemaDeMusica.service.Interfaces.IMusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/musica")
public class MusicaController {

      @Autowired
      private IMusicaService musicaService;


      @GetMapping
      public ResponseEntity buscaArtista(){
            return ResponseEntity.ok().body(musicaService.recuperaMusicas());
      }

      @GetMapping("/{id}")
      public ResponseEntity buscaArtistaPor(@PathVariable Integer id){
            return ResponseEntity.ok().body(musicaService.recuperaMusicaPor(id));
      }

      @PostMapping
      public ResponseEntity InsereArtista(@RequestBody Musica musica){
            musicaService.insereMusica(musica);
            return ResponseEntity.ok().body(musicaService.recuperaMusicas());
      }


      @DeleteMapping("/{id}")
      public ResponseEntity excluiArtistaPor(@PathVariable Integer id){
            musicaService.excluiMusicaPor(id);
            return ResponseEntity.status(HttpStatus.OK).build();
      }

      @PutMapping("/{id}")
      public ResponseEntity atualizaAlbum(@PathVariable Integer id){
            return ResponseEntity.ok().body(musicaService.atualizaMusica(id));
      }


}
