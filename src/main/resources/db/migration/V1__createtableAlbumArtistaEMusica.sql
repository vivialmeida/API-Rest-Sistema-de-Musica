CREATE TABLE PUBLIC.Album (
                              album_id  bigint auto_increment not null ,
                              nome varchar(100)  not null ,
                              ano bigint NULL,
                              participantes varchar(100),
                              musicas varchar(100),
                              primary key (album_id)

)engine =InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE PUBLIC.Musica(
                              musica_id  bigint auto_increment not null ,
                              nome varchar(100)  not null ,
                              duracao time,
                              artista_musica_id int,
                              primary key (musica_id)


)engine =InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE PUBLIC.Artista (
                                artista_id  bigint auto_increment not null ,
                                nome varchar(100)  not null ,
                                nacionalidade varchar(45),
                                artista_musica int
)engine =InnoDB DEFAULT CHARSET=utf8;