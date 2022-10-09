package com.crossguild.elearning.service.impl;

import com.crossguild.elearning.model.Card.Page;
import com.crossguild.elearning.repo.PageRepo;
import com.crossguild.elearning.service.PageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PageServiceImpl implements PageService {

    private final PageRepo pageRepo;

    public PageServiceImpl(PageRepo pageRepo) {
        this.pageRepo = pageRepo;
    }


    @Override
    public List<Page> getAll() {
        return pageRepo.findAll();
    }

    @Override
    public Optional<Page> getById(Long id) {
        return pageRepo.findById(id);
    }

    @Override
    public Page save(Page page) {
        return pageRepo.save(page);
    }

    @Override
    public Page update(Page page) {
        return pageRepo.save(page);
    }

    @Override
    public void deleteById(Long id) {
        pageRepo.deleteById(id);
    }
}
