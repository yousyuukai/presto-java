package com.yousyuukai.presto.api.controller;

import com.yousyuukai.presto.api.dao.PrestoDao;
import com.yousyuukai.presto.api.entity.BookEntity;
import com.yousyuukai.presto.api.repository.BookRepository;
import com.yousyuukai.presto.api.request.PrestoQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@RequestMapping("presto")
public class PrestoController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(PrestoController.class);

    private final BookRepository bookRepository;

    @Autowired
    private PrestoDao prestoDao;

    public PrestoController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Object query(@Validated @RequestBody PrestoQuery body, BindingResult errors) throws Exception {
        this.validationHandler(errors, logger);
        List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
        results = prestoDao.query(body.getQuerySql());
        return results;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public List<BookEntity> findBookList() {
        List<BookEntity> books = this.bookRepository.findAll();
        return books;
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public BookEntity queryBook(@RequestParam("bookId") String bookId) {
        BookEntity book = this.bookRepository.findByBookId(bookId);
        return book;
    }

}
