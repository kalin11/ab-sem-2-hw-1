package ru.kalin.absem2hw1.mappers;

import org.mapstruct.Mapper;
import ru.kalin.absem2hw1.dto.responses.AuthorResponseDto;
import ru.kalin.absem2hw1.model.Author;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorResponseDto toResponseDto(Author author);
}
