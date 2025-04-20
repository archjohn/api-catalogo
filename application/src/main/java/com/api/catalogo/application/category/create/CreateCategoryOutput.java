package com.api.catalogo.application.category.create;

import com.api.catalogo.domain.category.Category;
import com.api.catalogo.domain.category.CategoryID;

public record CreateCategoryOutput(
    CategoryID id
) {
    public static  CreateCategoryOutput from(final Category aCategory) {
        return new CreateCategoryOutput(aCategory.getId());
    }
}
