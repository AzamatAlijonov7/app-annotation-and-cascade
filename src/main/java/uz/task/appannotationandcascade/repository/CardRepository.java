package uz.task.appannotationandcascade.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import uz.task.appannotationandcascade.entity.Card;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface CardRepository extends JpaRepository<Card, List> {
    @Override
    public default void flush() {

    }

    @Override
    public default <S extends Card> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public default void deleteAllInBatch(Iterable<Card> entities) {

    }

    @Override
    public default void deleteAllByIdInBatch(Iterable<List> lists) {

    }

    @Override
    public default void deleteAllInBatch() {

    }

    @Override
    public default Card getOne(List list) {
        return null;
    }

    @Override
    public default Card getById(List list) {
        return null;
    }

    @Override
    public default Card getReferenceById(List list) {
        return null;
    }

    @Override
    public default <S extends Card> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public default <S extends Card> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public default <S extends Card> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public default <S extends Card> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public default <S extends Card> long count(Example<S> example) {
        return 0;
    }

    @Override
    public default <S extends Card> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public default <S extends Card, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public default <S extends Card> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public default <S extends Card> S save(S entity) {
        return null;
    }

    @Override
    public default <S extends Card> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public default Optional<Card> findById(List list) {
        return Optional.empty();
    }

    @Override
    public default boolean existsById(List list) {
        return false;
    }

    @Override
    public default List<Card> findAll() {
        return null;
    }

    @Override
    public default List<Card> findAllById(Iterable<List> lists) {
        return null;
    }

    @Override
    public default long count() {
        return 0;
    }

    @Override
    public default void deleteById(List list) {

    }

    @Override
    public default void delete(Card entity) {

    }

    @Override
    public default void deleteAllById(Iterable<? extends List> lists) {

    }

    @Override
    public default void deleteAll(Iterable<? extends Card> entities) {

    }

    @Override
    public default void deleteAll() {

    }

    @Override
    public default List<Card> findAll(Sort sort) {
        return null;
    }

    @Override
    public default Page<Card> findAll(Pageable pageable) {
        return null;
    }
}
