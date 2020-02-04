package br.com.lpweb.sistemaDeMusica.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "artista")
public class Artista {
      @Id @GeneratedValue
      Integer id;
      String nome;
      String nacionalidade;








}
