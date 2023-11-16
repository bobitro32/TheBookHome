package com.example.thebookhome.model;

import com.example.thebookhome.model.BaseEntity;
import com.example.thebookhome.model.enums.CategoriesEnum;
import jakarta.persistence.*;


@Entity
@Table(name = "books")
public class BookEntity extends BaseEntity {
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;//TODO:I should make authors table
    @Lob
    @Column(name="image",nullable = false,columnDefinition="BLOB")
    private String image;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoriesEnum category;

    public BookEntity() {
    }

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public CategoriesEnum getCategory() {
        return category;
    }

    public void setCategory(CategoriesEnum category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
