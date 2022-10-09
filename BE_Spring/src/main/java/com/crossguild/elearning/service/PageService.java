package com.crossguild.elearning.service;

import com.crossguild.elearning.model.Card.Page;

import java.util.List;

public interface PageService extends Service<Page, Long> {
    List<Page> getPagesByCardId(Long id);
}
