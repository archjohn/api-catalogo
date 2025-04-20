package com.api.catalogo.domain.category;

import com.api.catalogo.domain.AggregateRoot;
import com.api.catalogo.domain.validation.ValidationHandler;

import java.time.Instant;

public class Category extends AggregateRoot<CategoryID> {

    private final String name;
    private final String description;
    private final boolean isActive;
    private final Instant createdAt;
    private final Instant updateAt;
    private final Instant deletedAt;

    public Category(
        final CategoryID anId,
        final String aName,
        final String aDescription,
        final boolean isActive,
        final Instant aCreatedAt,
        final Instant aUpdateAt,
        final Instant aDeletedAt
    ) {
        super(anId);
        this.name = aName;
        this.description = aDescription;
        this.isActive = isActive;
        this.createdAt = aCreatedAt;
        this.updateAt = aUpdateAt;
        this.deletedAt = aDeletedAt;
    }

    @Override
    public void validate(final ValidationHandler handler) {
        new CategoryValidator(this, handler).validate();
    }

    public CategoryID getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public static Category newCategory(final String aName, final String aDescription, final boolean isActive) {
        final var id = CategoryID.unique();
        final var now = Instant.now();
        final var deletedAt = isActive ? null : now;
        return new Category(id, aName, aDescription, isActive, now, now, deletedAt);
    }
}
