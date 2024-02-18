package ru.kalin.absem2hw1.dto.responses;

public record AuthorResponseDto(
        Long id,
        String name,
        String surname,
        Integer age) {
}
