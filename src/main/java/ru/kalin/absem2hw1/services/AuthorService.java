package ru.kalin.absem2hw1.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kalin.absem2hw1.model.Author;
import ru.kalin.absem2hw1.repositories.AuthorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Автора с id=" + id + " нет"));
    }


    public Author addAuthor(String name, String surname, Integer age) {
        Author author = Author.builder()
                .name(name)
                .surname(surname)
                .age(age)
                .build();
        return authorRepository.save(author);
    }


    public boolean deleteAuthorById(Long id) {
        boolean existsById = authorRepository.existsById(id);
        authorRepository.deleteById(id);
        return existsById;
    }

    public Author updateAuthor(Long id, String name, String surname, Integer age) {
        Author authorToUpdate = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Пользователя с id=" + id + " нет"));
        authorToUpdate.setName(name);
        authorToUpdate.setSurname(surname);
        authorToUpdate.setAge(age);
        return authorRepository.save(authorToUpdate);
    }
}
