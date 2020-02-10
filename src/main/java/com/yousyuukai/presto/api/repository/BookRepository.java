package com.yousyuukai.presto.api.repository;

import com.yousyuukai.presto.api.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, String> {
    List<BookEntity> findAll();

    BookEntity findByBookId(String bookId);

    BookEntity save(BookEntity book);
}
