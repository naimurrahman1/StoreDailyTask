package com.bjit.bookLibrary.controller;

import com.bjit.bookLibrary.model.BookRequestModel;
import com.bjit.bookLibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService userService;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody BookRequestModel requestModel) {
        return userService.create(requestModel);
    }

    @PutMapping("/update/{bookId}")
    public void updateBookEntity(@PathVariable Long id, @RequestBody BookRequestModel requestModel) {
        userService.updateBookEntity(id, requestModel);
    }



    @GetMapping("/showAll")
    public ResponseEntity detail(@RequestBody BookRequestModel requestModel) {
        return userService.showAll(requestModel);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "User has been Deleted";
    }







}