package br.com.lpweb.sistemaDeMusica.controller;

import br.com.lpweb.sistemaDeMusica.controller.validacao.Validacao;
import br.com.lpweb.sistemaDeMusica.model.Artista;
import br.com.lpweb.sistemaDeMusica.model.handler.Resposta;
import br.com.lpweb.sistemaDeMusica.model.handler.StandardError;
import br.com.lpweb.sistemaDeMusica.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/artista")
public class ArtistaController {

      @Autowired
      private ArtistaService artistaService;

      @GetMapping
      public Resposta<List<Artista>> buscaArtista(){
            return Resposta.comDadosDe(artistaService.recuperaArtistas());
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
      public ResponseEntity<Resposta<Artista>>  InsereArtista(@Valid  @RequestBody Artista artista){
           Artista artistaSalvo = artistaService.insereArtista(artista);
            return ResponseEntity.ok().body(Resposta.comDadosDe(artistaSalvo));
      }


      @DeleteMapping("/{id}")
      @ResponseStatus(HttpStatus.NO_CONTENT)
      public void excluiArtistaPor(@PathVariable Integer id){
            artistaService.excluiArtistaPor(id);
      }

      @PutMapping("/{id}")
      public ResponseEntity<Resposta<Artista>> atualizaArtista(@PathVariable Integer id, @RequestBody Artista artista){
            Artista artistaAtualizado = artistaService.atualizaArtista(artista, id );
            List<StandardError> erros = this.getErros(artistaAtualizado);
            if (existe(erros)) {
                  return ResponseEntity.badRequest().body(Resposta.com(erros) );
            }
            return ResponseEntity.ok().body(Resposta.comDadosDe(artistaAtualizado));
      }

      private boolean existe(List<StandardError> erros) {
            return Objects.nonNull( erros ) &&  !erros.isEmpty();
      }

      private List<StandardError> getErros(Artista artista) {
            Validacao<Artista> validacao = new Validacao<>();
            return validacao.valida(artista);
      }

}
