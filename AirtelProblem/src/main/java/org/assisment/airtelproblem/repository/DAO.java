package org.assisment.airtelproblem.repository;

public interface DAO<T> {
    int save(T t);
}
