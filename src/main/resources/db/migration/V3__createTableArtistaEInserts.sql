CREATE TABLE PUBLIC.Artista (
                              artista_id  bigint auto_increment not null ,
                              nome varchar(100)  not null ,
                              nacionalidade varchar(45)




)engine =InnoDB DEFAULT CHARSET=utf8;

insert into Artista(nome, nacionalidade)  values ('Duda Beat', 'BR'), ('Jao', 'BR'), ('Camilla Cabelo', 'UK')