package com.MATS.Migration_Certificate.service.implementation;

import com.MATS.Migration_Certificate.dto.requestDto.MigrationRequestDto;
import com.MATS.Migration_Certificate.dto.responseDto.MigrationResponseDto;
import com.MATS.Migration_Certificate.entity.Migration;
import com.MATS.Migration_Certificate.mapper.MigrationMapper;
import com.MATS.Migration_Certificate.repository.MigrationRepository;
import com.MATS.Migration_Certificate.service.MigrationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MigrationServiceImpl implements MigrationService {

    private final MigrationRepository migrationRepository;
    private final MigrationMapper migrationMapper;

    @Override
    public MigrationResponseDto createMigration(MigrationRequestDto migrationRequestDto) throws IOException {
        Migration migration = migrationMapper.toMigration(migrationRequestDto);
        migration.setImage(saveFile(migrationRequestDto.getImageFile()));
        Migration savedMigration = migrationRepository.save(migration);
        return migrationMapper.toMigrationResponseDto(savedMigration);
    }

    @Override
    public MigrationResponseDto getMigration(Long id) {
        Migration migration = migrationRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Migration not found"));
        return migrationMapper.toMigrationResponseDto(migration);
    }

    @Override
    public byte[] generateMigrationCertificate(Long id) throws JRException {
        String resourceDir = System.getProperty("user.dir")+"\\src\\main\\resources\\report\\";
        Path migrationPath = Paths.get(resourceDir,"MigrationCertificate.jrxml");
        JasperReport migrationReport = JasperCompileManager.compileReport(migrationPath.toString());
        Migration migration = migrationRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Migration not found"));
        JRBeanCollectionDataSource migrationDataSource = new JRBeanCollectionDataSource(Collections.singletonList(migration));
        Map<String, Object> data = new HashMap<>();
        for(Field field : migration.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                data.put(field.getName(), field.get(migration));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("data", data);
        JasperPrint jasperPrint = JasperFillManager.fillReport(migrationReport, parameters, migrationDataSource);
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

    private String saveFile(MultipartFile file) throws IOException {
        String uploadDir = System.getProperty("user.dir")+"\\src\\main\\resources\\webapp\\images\\";
        Files.createDirectories(Paths.get(uploadDir));
        String fileName = System.currentTimeMillis()+"-"+file.getOriginalFilename();
        Path path = Paths.get(uploadDir,fileName);
        Files.write(path, file.getBytes());
        return path.toString();
    }
}
