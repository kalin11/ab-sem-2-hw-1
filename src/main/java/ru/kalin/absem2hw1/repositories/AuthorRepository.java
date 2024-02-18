package ru.kalin.absem2hw1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kalin.absem2hw1.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
