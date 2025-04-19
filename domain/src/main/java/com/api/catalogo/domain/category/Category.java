package com.api.catalogo.domain.category;

import java.time.Instant;

public class Category {

    private String name;
    private String description;
    private boolean IsActive;
    private Instant createdAt;
    private Instant updateAt;
    private  Instant deletedAt;

    public Category(
        String name,
        String description,
        boolean isActive,
        Instant createdAt,
        Instant updateAt,
        Instant deletedAt
    ) {
        this.name = name;
        this.description = description;
        IsActive = isActive;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.deletedAt = deletedAt;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return IsActive;
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
}
