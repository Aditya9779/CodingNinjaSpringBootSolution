package com.example.website.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

//DOA is data access object

public interface DAO<T> {
    public Optional<T> findById(Integer id);

    public int save(T t);
}
