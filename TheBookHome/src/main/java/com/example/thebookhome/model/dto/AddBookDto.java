package com.example.thebookhome.model.dto;
import com.example.thebookhome.model.enums.CategoriesEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;


public class AddBookDto {
    @NotNull(message="Title can not be null!")
    private String title;
    @NotNull(message="Author can not be null!")
    private String author;
    @NotNull(message="Description can not be null!")
    private String description;
    @NotNull(message="You should upload image of the book!")
    private MultipartFile file;
    @Positive
    @NotNull(message="Price can not be null!")
    private Integer price;
    @NotNull(message="Choose category of the book!")
    private CategoriesEnum category;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public CategoriesEnum getCategory() {
        return category;
    }

    public void setCategory(CategoriesEnum category) {
        this.category = category;
    }

    public AddBookDto() {
    }

    public AddBookDto(String title, String author, String description, MultipartFile file, Integer price, CategoriesEnum category) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.file = file;
        this.price = price;
        this.category = category;
    }

    public static AddBookDto empty(){
        return new AddBookDto(null,null,null,null,null,null);
    }
}
