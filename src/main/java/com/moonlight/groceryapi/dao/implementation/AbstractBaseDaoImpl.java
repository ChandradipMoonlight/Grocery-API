package com.moonlight.groceryapi.dao.implementation;

import com.moonlight.groceryapi.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.data.relational.core.sql.Where;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public abstract class AbstractBaseDaoImpl<T> {

    @Autowired
    R2dbcEntityTemplate r2dbcEntityTemplate;

    protected Flux<T> findAll(final Class<T> tClass) {
        return r2dbcEntityTemplate.select(tClass)
                .all();
    }

    protected Mono<T> save(final  T t) {
        log.info("T : {}", t.toString());
        return r2dbcEntityTemplate
                .insert(t);
    }

    protected Mono<Long> deleteById(final Class<T> tClass, String key, Long id) {
        Query query = Query.query(Criteria.where(key).is(id));
        return r2dbcEntityTemplate
                .delete(tClass)
                .matching(query)
                .all();
    }

    protected Mono<T> findById(final Class<T> tClass, String key, Long id) {
        return r2dbcEntityTemplate
                .selectOne(Query.query(Criteria.where(key).is(id)), tClass);
    }

    protected Mono<Long> delete(final T t) {
        return r2dbcEntityTemplate.delete(t.getClass())
                .all();
    }

    protected Mono<T> update(final T t) {
        return r2dbcEntityTemplate
                .update(t);
    }

}
