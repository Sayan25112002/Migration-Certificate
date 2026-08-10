package com.MATS.Migration_Certificate.controller;

import com.MATS.Migration_Certificate.dto.requestDto.MigrationRequestDto;
import com.MATS.Migration_Certificate.dto.responseDto.MigrationResponseDto;
import com.MATS.Migration_Certificate.service.MigrationService;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class MigrationController {

    private final MigrationService migrationService;

    @PostMapping("/createMigration")
    public MigrationResponseDto createMigration(@ModelAttribute MigrationRequestDto migrationRequestDto) throws IOException {
        return migrationService.createMigration(migrationRequestDto);
    }

    @GetMapping("/getMapping/{id}")
    public MigrationResponseDto getMapping(@PathVariable Long id) {
        return migrationService.getMigration(id);
    }

    @GetMapping("/generateMigrationCertificate/{id}")
    public HttpEntity<byte[]> generateMigrationCertificate(@PathVariable Long id) throws JRException {
        byte[] migrationCertificate = migrationService.generateMigrationCertificate(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment","Migration Certificate.pdf");
        return new HttpEntity<>(migrationCertificate,headers);
    }
}
