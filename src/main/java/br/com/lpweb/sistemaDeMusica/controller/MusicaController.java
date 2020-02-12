package br.com.lpweb.sistemaDeMusica.controller;
import br.com.lpweb.sistemaDeMusica.model.Musica;
import br.com.lpweb.sistemaDeMusica.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/musica")
public class MusicaController {


      private final MusicaService musicaService;

      @Autowired
      public MusicaController(MusicaService musicaService) {
            this.musicaService = musicaService;
      }


      @GetMapping
      public ResponseEntity buscaMusicas(){
            return ResponseEntity.ok().body(musicaService.recuperaMusicas());
      }

      @GetMapping("/{id}")
      public ResponseEntity buscaMusicaPor(@PathVariable Integer id){
            return ResponseEntity.ok().body(musicaService.recuperaMusicaPor(id));
      }

      @PostMapping
      public ResponseEntity InsereArtista(@Valid  @RequestBody Musica musica){
            musicaService.insereMusica(musica);
            return ResponseEntity.ok().body(musicaService.recuperaMusicas());
      }


      @DeleteMapping("/{id}")
      public ResponseEntity excluiArtistaPor(@PathVariable Integer id){
            musicaService.excluiMusicaPor(id);
            return ResponseEntity.status(HttpStatus.OK).build();
      }

      @PutMapping("/{id}")
      public ResponseEntity atualizaAlbum(@PathVariable Integer id, @Valid  @RequestBody Musica musica){
            return ResponseEntity.ok().body(musicaService.atualizaMusica(musica, id));
      }


}
