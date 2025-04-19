package com.api.catalogo.domain.category;

import java.time.Instant;
import java.util.UUID;

public class Category {

    private final String id;
    private final String name;
    private final String description;
    private final boolean isActive;
    private final Instant createdAt;
    private final Instant updateAt;
    private final Instant deletedAt;

    public Category(
        final String id,
        final String name,
        final String description,
        final boolean isActive,
        final Instant createdAt,
        final Instant updateAt,
        final Instant deletedAt
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.deletedAt = deletedAt;
    }

    public String getId() {
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
        final var id = UUID.randomUUID().toString();
        final var now = Instant.now();
        return new Category(id, aName, aDescription, isActive, now, now, null);
    }
}
