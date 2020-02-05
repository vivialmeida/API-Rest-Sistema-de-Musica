CREATE TABLE PUBLIC.Musica(
                              musica_id  bigint auto_increment not null ,
                              nome varchar(100)  not null ,
                              duracao time


)engine =InnoDB DEFAULT CHARSET=utf8;

insert into Musica(nome, duracao)  values ('Bixinho', '00:03:00'), ('Aqui', '00:3:16'), ('Consequenses', '00:02:58')