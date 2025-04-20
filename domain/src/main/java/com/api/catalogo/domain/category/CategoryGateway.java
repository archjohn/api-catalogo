package com.api.catalogo.domain.category;

import com.api.catalogo.domain.pagination.Pagination;

import java.util.Optional;

public interface CategoryGateway {

    Category create(Category aCategory);
    void deleteById(CategoryID anId);
    Optional<Category> findById(CategoryID anId);
    Category update(CategoryID anId);

    Pagination<Category> findAll(CategorySearchQuery aQuery);
}
