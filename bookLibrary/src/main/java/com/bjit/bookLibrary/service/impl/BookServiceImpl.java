package com.bjit.bookLibrary.service.impl;

import com.bjit.bookLibrary.entity.BookEntity;
import com.bjit.bookLibrary.model.BookRequestModel;
import com.bjit.bookLibrary.repository.BookRepository;
import com.bjit.bookLibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public ResponseEntity<Object> create(BookRequestModel bookRequestModel) {
        BookEntity bookEntity = BookEntity.builder()
                .bookName(bookRequestModel.getBookName())
                .authorName(bookRequestModel.getAuthorName())
                .build();
        BookEntity savedBookEntity = bookRepository.save(bookEntity);

        return new ResponseEntity<>(savedBookEntity, HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity<Object> showAll(BookRequestModel bookRequestModel) {
        List<BookEntity> bookList = bookRepository.findAll();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }
    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }



    @Override
    public void updateBookEntity(Long id, BookRequestModel requestModel) {

        BookEntity bookFromDB = bookRepository.findById(id).get();
        bookFromDB.setBookName(requestModel.getBookName());
        bookFromDB.setAuthorName(requestModel.getAuthorName()
        );
        bookRepository.save(bookFromDB);

    }


}




