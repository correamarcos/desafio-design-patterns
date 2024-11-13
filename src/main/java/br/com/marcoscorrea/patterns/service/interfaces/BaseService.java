package br.com.marcoscorrea.patterns.service.interfaces;

public interface BaseService<T> {
    Iterable<T> getAll();
    T getById(Long id);
    void create(T obj);
    void update(Long id, T obj);
    void delete(Long id);
}
