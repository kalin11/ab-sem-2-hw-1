package ru.kalin.absem2hw1.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import ru.kalin.absem2hw1.dto.responses.AuthorResponseDto;
import ru.kalin.absem2hw1.mappers.AuthorMapper;
import ru.kalin.absem2hw1.services.AuthorService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @QueryMapping
    public List<AuthorResponseDto> getAuthors() {
        return authorService.getAuthors().stream().map(authorMapper::toResponseDto).toList();
    }

    @QueryMapping
    public AuthorResponseDto getAuthorById(@Argument Long id) {
        return authorMapper.toResponseDto(authorService.getAuthorById(id));
    }

    @MutationMapping
    public AuthorResponseDto addAuthor(@Argument String name, @Argument String surname, @Argument Integer age) {
        return authorMapper.toResponseDto(authorService.addAuthor(name, surname, age));
    }

    @MutationMapping
    public boolean deleteAuthorById(@Argument Long id) {
        return authorService.deleteAuthorById(id);
    }

    @MutationMapping
    public AuthorResponseDto updateAuthor(@Argument Long id,
                                          @Argument String name,
                                          @Argument String surname,
                                          @Argument Integer age) {
        return authorMapper.toResponseDto(authorService.updateAuthor(id, name, surname, age));
    }
}
