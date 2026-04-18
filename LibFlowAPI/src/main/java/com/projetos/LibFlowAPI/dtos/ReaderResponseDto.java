package com.projetos.LibFlowAPI.dtos;

import jakarta.validation.constraints.Email;

import java.time.LocalDate;
import java.util.Objects;

public class ReaderResponseDto {
    private Long id;
    private String name;

    @Email(message = "Este campo de conter um valor válido")
    private String email;
    private String phone;
    private LocalDate localDate;

    public ReaderResponseDto() {
    }

    public ReaderResponseDto(String email, Long id, LocalDate localDate, String name, String phone) {
        this.email = email;
        this.id = id;
        this.localDate = localDate;
        this.name = name;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }


    public Long getId() {
        return id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }


    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        ReaderResponseDto that = (ReaderResponseDto) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(email);
        return result;
    }
}
