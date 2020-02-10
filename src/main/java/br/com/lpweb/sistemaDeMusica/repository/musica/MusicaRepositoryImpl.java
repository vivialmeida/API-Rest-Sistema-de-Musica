package br.com.lpweb.sistemaDeMusica.repository.musica;

import br.com.lpweb.sistemaDeMusica.model.Musica;
import br.com.lpweb.sistemaDeMusica.repository.filtro.MusicaFiltro;
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

public class MusicaRepositoryImpl implements  MusicaRepositoryQuery{

      @PersistenceContext
      private EntityManager manager;

      @Override
      public Page<Musica> filtrar(MusicaFiltro filtro, Pageable pageable) {
//
//             Usamos o CriteriaBuilder(cb) para criar a CriteriaQueyr (cQuery)
//             com a tipagem do tipo a ser selecionado (Produto)
            CriteriaBuilder cBuilder = manager.getCriteriaBuilder();


            // 1. Select p From Produto p
            CriteriaQuery<Musica> cQuery = cBuilder.createQuery(Musica.class );

            // 2. clausula from e joins
            Root<Musica> produtoRoot = cQuery.from(Musica.class );

            // 3. adiciona as restrições (os predicados) que serão passadas na clausula where
            Predicate[] restricoes = this.criaRestricoes(filtro, cBuilder, produtoRoot  );


            // 4. monta a consulta com as restrições
            cQuery.select(produtoRoot)
                    .where(restricoes )
                    .orderBy( cBuilder.desc(produtoRoot.get("nome")) );

            // 5. cria e executa a consula
            TypedQuery<Musica> query = manager.createQuery(cQuery);
            adicionaRestricoesDePaginacao(query, pageable);

            return new PageImpl<Musica>(query.getResultList(), pageable, total(filtro) );
      }


      private Predicate[] criaRestricoes(MusicaFiltro filtro, CriteriaBuilder cBuilder, Root<Musica> musicaRoot) {

            List<Predicate> predicates = new ArrayList<>();

            if ( !StringUtils.isEmpty( filtro.getArtista()) ) {
                  // where nome like %Computador%
                  predicates.add(cBuilder.like(cBuilder.lower(musicaRoot.get("nome")), "%" + filtro.getArtista().toLowerCase() + "%" ) );

            }

            if ( Objects.nonNull(filtro.getDuracaoDe()) ) {
                  predicates.add( cBuilder.like( musicaRoot.get("duracao"), filtro.getDuracaoDe().toString() ));
            }

            if( Objects.nonNull( filtro.getDuracaoAte()  ) ) {
                  predicates.add( cBuilder.like( musicaRoot.get("duracao"), filtro.getDuracaoAte().toString()));
            }

            return predicates.toArray(new Predicate[ predicates.size() ] );
      }



      private void adicionaRestricoesDePaginacao(TypedQuery<Musica> query, Pageable pageable) {
            Integer paginaAtual = pageable.getPageNumber();
            Integer totalObjetosPorPagina = pageable.getPageSize();
            Integer primeiroObjetoDaPagina = paginaAtual * totalObjetosPorPagina;

            // 0 a n-1, n - (2n -1), ...
            query.setFirstResult(primeiroObjetoDaPagina );
            query.setMaxResults(totalObjetosPorPagina );

      }

      private Long total(MusicaFiltro filtro) {
            CriteriaBuilder cBuilder = manager.getCriteriaBuilder();
            CriteriaQuery<Long> cQuery = cBuilder.createQuery(Long.class);

            Root<Musica> rootMusica = cQuery.from(Musica.class);

            Predicate[] predicates = criaRestricoes(filtro, cBuilder, rootMusica);

            cQuery.where(predicates );
            cQuery.select( cBuilder.count(rootMusica) );

            return manager.createQuery(cQuery).getSingleResult();

      }
}
