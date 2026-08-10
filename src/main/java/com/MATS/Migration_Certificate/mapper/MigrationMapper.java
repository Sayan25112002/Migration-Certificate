package com.MATS.Migration_Certificate.mapper;

import com.MATS.Migration_Certificate.dto.requestDto.MigrationRequestDto;
import com.MATS.Migration_Certificate.dto.responseDto.MigrationResponseDto;
import com.MATS.Migration_Certificate.entity.Migration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MigrationMapper {

    Migration toMigration(MigrationRequestDto migrationRequestDto);

    MigrationResponseDto toMigrationResponseDto(Migration migration);

    List<MigrationResponseDto> toMigrationResponseDtoList(List<Migration> migrations);

}
