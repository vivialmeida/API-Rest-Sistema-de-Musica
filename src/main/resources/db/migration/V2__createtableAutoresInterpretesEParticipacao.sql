
CREATE TABLE autorias (
  id_artista INT NOT NULL,
  id_musica INT NOT NULL,
--   PRIMARY KEY (id_artista, id_musica),
  foreign key(id_artista) references artistas(artista_id),
  foreign key(id_musica) references musicas(musica_id)
) ;


CREATE TABLE interpretacoes (
  id_artista INT NOT NULL,
  id_musica INT NOT NULL,
  PRIMARY KEY (id_artista, id_musica),
    foreign key(id_artista) references artistas(artista_id),
    foreign key(id_musica) references musicas(musica_id)
);

CREATE TABLE participacoes (
                               id_artista INT NOT NULL,
                               id_album INT NOT NULL,
                               PRIMARY KEY (id_album, id_artista),
                               foreign key(id_album) references albuns(album_id),
                               foreign key(id_artista) references artistas(artista_id)
);

CREATE TABLE album_musica (
  id_album INT NOT NULL,
  id_musica INT NOT NULL,
  PRIMARY KEY (id_musica, id_album),
  foreign key(id_musica) references musicas(musica_id),
  foreign key(id_album) references albuns(album_id)
) ;

CREATE TABLE albuns_participantes (
      id_album INT NOT NULL,
      id_artista INT NOT NULL,
          foreign key(id_artista) references artistas(artista_id),
          foreign key(id_album) references albuns(album_id)

)