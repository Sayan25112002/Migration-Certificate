package com.MATS.Migration_Certificate.service;

import com.MATS.Migration_Certificate.dto.requestDto.MigrationRequestDto;
import com.MATS.Migration_Certificate.dto.responseDto.MigrationResponseDto;
import net.sf.jasperreports.engine.JRException;

import java.io.IOException;

public interface MigrationService {

    MigrationResponseDto createMigration(MigrationRequestDto migrationRequestDto) throws IOException;

    MigrationResponseDto getMigration(Long id);

    byte[] generateMigrationCertificate(Long id) throws JRException;

}
