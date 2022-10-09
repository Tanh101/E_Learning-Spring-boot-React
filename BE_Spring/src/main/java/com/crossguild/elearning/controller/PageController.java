package com.crossguild.elearning.controller;

import com.crossguild.elearning.model.Card.Card;
import com.crossguild.elearning.model.Card.Page;
import com.crossguild.elearning.service.PageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/page")
@RestController
public class PageController {

    private final PageService pageService;

    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Page>> GetAllPages() {
        List<Page> pages = pageService.getAll();
        return new ResponseEntity<>(pages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Page>> getPageById(@PathVariable("id") Long id) {
        Optional<Page> page = pageService.getById(id);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Page> addNewPage(@RequestBody Page page)  {
        Page newPage = pageService.save(page);
        return new ResponseEntity<>(newPage, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Page> updatePage(@RequestBody Page page) {
        Page updatePage = pageService.save(page);
        return new ResponseEntity<>(updatePage, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePageById(@PathVariable("id") Long id) {
        pageService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
