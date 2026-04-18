package com.projetos.LibFlowAPI.mappers;

import com.projetos.LibFlowAPI.dtos.ReaderRequestDto;
import com.projetos.LibFlowAPI.dtos.ReaderResponseDto;
import com.projetos.LibFlowAPI.entities.Reader;

public class ReaderMapper {

    public static Reader toEntity(ReaderRequestDto dto){
        Reader reader = new Reader();
        reader.setName(dto.getName());
        reader.setEmail(dto.getEmail());
        reader.setPhone(dto.getPhone());
        reader.setPassword(dto.getPassword());
        reader.setLocalDate(dto.getLocalDate());
        return reader;
    }

    public static ReaderResponseDto toResponseDTO(Reader reader){
        return new ReaderResponseDto(
                reader.getEmail(),
                reader.getId(),
                reader.getLocalDate(),
                reader.getName(),
                reader.getPhone()
        );
    }
}
