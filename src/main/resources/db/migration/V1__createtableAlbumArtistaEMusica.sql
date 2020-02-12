CREATE TABLE IF NOT EXISTS  Albuns (
                              album_id int auto_increment not null ,
                              nome varchar(100)  not null ,
                              ano bigint NULL,
                              primary key (album_id)

);

CREATE TABLE IF NOT EXISTS  Musicas(
                              musica_id  int auto_increment not null ,
                              nome varchar(100)  not null ,
                              duracao int,
                              primary key (musica_id)
,

);

CREATE TABLE IF NOT EXISTS  Artistas (
                                artista_id  int auto_increment not null ,
                                nome varchar(100)  not null ,
                                nacionalidade varchar(45),
                                primary key (artista_id)
);