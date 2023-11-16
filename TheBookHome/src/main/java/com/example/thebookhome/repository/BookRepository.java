package com.example.thebookhome.repository;

import com.example.thebookhome.model.BookEntity;
import com.example.thebookhome.model.enums.CategoriesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {
    List<BookEntity> findBookEntitiesByCategory(CategoriesEnum category);
}
