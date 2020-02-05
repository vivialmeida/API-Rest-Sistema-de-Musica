CREATE TABLE PUBLIC.Album (
                              album_id  bigint auto_increment not null ,
                              nome varchar(100)  not null ,
                              ano bigint NULL,
                              participantes varchar(100),
                              musicas varchar(100)



)engine =InnoDB DEFAULT CHARSET=utf8;