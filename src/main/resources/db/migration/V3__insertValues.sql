insert into Albuns (nome, ano ) values ('Desconstrucao', '2020');
insert into Albuns (nome, ano ) values ('Lord', '2020');
insert into Albuns (nome, ano ) values ('Behavior', '2020');

insert into Musicas(musica_id, nome, duracao)  values (default, 'Bixinho', '00:03:00'), (default, 'Aqui', '00:3:16'), (default, 'Consequenses', '00:02:58');

insert into Artistas(artista_id, nome, nacionalidade)  values (default, 'Duda Beat', 'BR'), (default, 'Jao', 'BR'), (default, 'Camilla Cabelo', 'UK');

insert into participacoes(id_album, id_artista) values (1,2), (1,1);

insert into album_musica(id_album, id_musica) values (1,1), (1,2);

insert into albuns_participantes(id_album, id_artista) values (1,2), (1,3);