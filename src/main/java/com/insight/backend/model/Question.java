package com.insight.backend.model;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "question")
    private Set<Rating> rating;
    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;
    private LocalDateTime DeletedAt;

    public Question(String name, Set<Rating> rating, Category category) {
        this.name = name;
        this.rating = rating;
        this.category = category;
    }

    public Question() {

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Rating> getRating() {
        return rating;
    }

    public void setRating(Set<Rating> rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDeletedAt(LocalDateTime DeletedAt) {
        this.DeletedAt = DeletedAt;
    }
    
    public LocalDateTime getDeletedAt() {
        return DeletedAt;
    }
}
