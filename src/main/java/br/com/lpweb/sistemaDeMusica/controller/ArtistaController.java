package br.com.lpweb.sistemaDeMusica.controller;

import br.com.lpweb.sistemaDeMusica.model.Artista;
import br.com.lpweb.sistemaDeMusica.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artista")
public class ArtistaController {

      @Autowired
      private ArtistaService artistaService;

      @GetMapping
      public ResponseEntity buscaArtista(){
            return ResponseEntity.ok().body(artistaService.recuperaArtistas());
      }

      @GetMapping("/{id}")
      public ResponseEntity buscaArtistaPor(@PathVariable Integer id){
            return ResponseEntity.ok().body(artistaService.recuperaArtistaPor(id));
      }
      @GetMapping("/nome")
      public ResponseEntity recuperaArtistaPor(@RequestParam("nome") String nome){
            return ResponseEntity.ok().body(artistaService.recuperaArtistaPorNome(nome));
      }

      @GetMapping("/nacionalidade")
      public ResponseEntity recuperaArtistaPorNacionalidade(@RequestParam("nacionalidade")  String nacionalidade){
            return ResponseEntity.ok().body(artistaService.recuperaArtistaPorNacionalidade(nacionalidade));
      }


      @PostMapping
      public ResponseEntity InsereArtista(@RequestBody Artista artista){
            artistaService.insereArtista(artista);
            return ResponseEntity.ok().body(artistaService.recuperaArtistas());
      }


      @DeleteMapping("/{id}")
      public ResponseEntity excluiArtistaPor(@PathVariable Integer id){
            artistaService.excluiArtistaPor(id);
            return ResponseEntity.status(HttpStatus.OK).build();
      }

      @PutMapping("/{id}")
      public ResponseEntity atualizaAlbum(@PathVariable Integer id, @RequestBody Artista artista){
            return ResponseEntity.ok().body(artistaService.atualizaArtista(artista, id ));
      }



}
