package com.bjit.bookLibrary.repository;

import com.bjit.bookLibrary.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {
    public BookEntity findById(String id);
}