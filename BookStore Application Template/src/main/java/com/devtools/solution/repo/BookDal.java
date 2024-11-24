package com.devtools.solution.repo;

import com.devtools.solution.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDal extends JpaRepository<Book, Integer> {}