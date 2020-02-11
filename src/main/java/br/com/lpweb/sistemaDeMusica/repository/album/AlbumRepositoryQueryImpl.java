package br.com.lpweb.sistemaDeMusica.repository.album;

import br.com.lpweb.sistemaDeMusica.model.Album;
import br.com.lpweb.sistemaDeMusica.repository.filtro.AlbumFiltro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class AlbumRepositoryQueryImpl implements AlbumRepositoryQuery {

      @PersistenceContext
      private EntityManager manager;

      @Override
      public Page<Album> filtrar(AlbumFiltro filtro, Pageable pageable) {

//             Usamos o CriteriaBuilder(cb) para criar a CriteriaQueyr (cQuery)
//             com a tipagem do tipo a ser selecionado (Produto)
            CriteriaBuilder cBuilder = manager.getCriteriaBuilder();


            // 1. Select p From Produto p
            CriteriaQuery<Album> cQuery = cBuilder.createQuery(Album.class );

            // 2. clausula from e joins+8
            Root<Album> albumRoot = cQuery.from(Album.class );

            // 3. adiciona as restrições (os predicados) que serão passadas na clausula where
            Predicate[] restricoes = this.criaRestricoes(filtro, cBuilder, albumRoot  );


            // 4. monta a consulta com as restrições
            cQuery.select(albumRoot)
                    .where(restricoes )
                    .orderBy( cBuilder.desc(albumRoot.get("ano")) );

            // 5. cria e executa a consula
            TypedQuery<Album> query = manager.createQuery(cQuery);
            adicionaRestricoesDePaginacao(query, pageable);

            return new PageImpl<Album>(query.getResultList(), pageable, total(filtro) );

      }


      private Predicate[] criaRestricoes(AlbumFiltro filtro, CriteriaBuilder cBuilder, Root<Album> albumRoot) {

            List<Predicate> predicates = new ArrayList<>();

            if ( !StringUtils.isEmpty( filtro.getNome()) ) {
                  // where nome like %Computador%
                  predicates.add(cBuilder.like(cBuilder.lower(albumRoot.get("nome")), "%" + filtro.getNome().toLowerCase() + "%" ) );

            }

            if ( Objects.nonNull(filtro.getAno())) {
                  predicates.add( cBuilder.ge( albumRoot.get("ano"), filtro.getAno()));
            }

            if( Objects.nonNull( filtro.getDuracao()) ) {
                  predicates.add( cBuilder.le(albumRoot.get("getDuracaoTotalAbum"), filtro.getDuracao()));
            }

            return predicates.toArray(new Predicate[ predicates.size() ] );
      }



      private void adicionaRestricoesDePaginacao(TypedQuery<Album> query, Pageable pageable) {
            Integer paginaAtual = pageable.getPageNumber();
            Integer totalObjetosPorPagina = pageable.getPageSize();
            Integer primeiroObjetoDaPagina = paginaAtual * totalObjetosPorPagina;

            // 0 a n-1, n - (2n -1), ...
            query.setFirstResult(primeiroObjetoDaPagina );
            query.setMaxResults(totalObjetosPorPagina );

      }

      private Long total(AlbumFiltro filtro) {
            CriteriaBuilder cBuilder = manager.getCriteriaBuilder();
            CriteriaQuery<Long> cQuery = cBuilder.createQuery(Long.class);

            Root<Album> rootAlbum= cQuery.from(Album.class);

            Predicate[] predicates = criaRestricoes(filtro, cBuilder, rootAlbum);

            cQuery.where(predicates );
            cQuery.select( cBuilder.count(rootAlbum) );

            return manager.createQuery(cQuery).getSingleResult();

      }
}
