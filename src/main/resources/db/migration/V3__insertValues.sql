insert into Albuns (nome, ano ) values ('Desconstrucao', '2020'), ('Lord', '2020'),('Behavior', '2020'), ('Estampa', '2018'),( 'Tua', '2009'), ('Descalço', '2015') ;




insert into Musicas(musica_id, nome, duracao)  values (default, 'Bixinho', 3), (default, 'Aqui', 4), (default, 'Consequenses', 2), (default, 'Nao é comum mais e normal', 3),
                                                      (default, 'I love you ', 5), (default, 'Bad',5 ), (default, 'Thinking out Loud', 2), (default, 'Man Down', 3),
                                                        (default, 'Sugar ', 5), (default, 'Stay with you',5 ), (default, 'All of me', 2), (default, 'Magic', 2);


insert into Artistas(artista_id, nome, nacionalidade)  values (default, 'Duda Beat', 'BR'), (default, 'Jao', 'BR'), (default, 'Camilla Cabelo', 'UK'),(default, 'Gloria Groove', 'BR'),
                                                                (default, 'Billie Eilish', 'BR'), (default, 'Maroon 5', 'BR'), (default, 'Ed Sheeran', 'UK'),(default, 'Rude', 'BR');

insert into participacoes(id_album, id_artista) values (1,2), (1,1), (1,5) ,(2,5),(1,3), (3,6), (4,7), (4,8);

insert into album_musica(id_album, id_musica) values (1,1), (1,2), (1,9), (2,1), (1,5) ,(2,5),(1,3), (3,6), (4,7), (4,8), (5,9), (6,11), (4,12);;

-- insert into albuns_participantes(id_album, id_artista) values (1,2), (1,3);