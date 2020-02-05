package br.com.lpweb.sistemaDeMusica.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "artista")
public class Artista {
      @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "artista_id")
      Integer id;
      @Column(name = "nome")
      String nome;
      @Column(name = "nacionalidade")
      String nacionalidade;








}
