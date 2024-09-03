package org.assisment.assisgnment.repository;

import java.util.Optional;

public interface DAO<T> {
     int saveDetails(T t);
    public Optional<T> get(Integer  id);
}
