package com.MATS.Migration_Certificate.service;

import com.MATS.Migration_Certificate.dto.requestDto.MigrationRequestDto;
import com.MATS.Migration_Certificate.dto.responseDto.MigrationResponseDto;

public interface MigrationService {

    MigrationResponseDto createMigration(MigrationRequestDto migrationRequestDto);

    MigrationResponseDto getMigration(Long id);

    byte[] generateMigrationCertificate(Long id);

}
