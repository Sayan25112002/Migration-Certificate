package com.MATS.Migration_Certificate.service.implementation;

import com.MATS.Migration_Certificate.dto.requestDto.MigrationRequestDto;
import com.MATS.Migration_Certificate.dto.responseDto.MigrationResponseDto;
import com.MATS.Migration_Certificate.entity.Migration;
import com.MATS.Migration_Certificate.mapper.MigrationMapper;
import com.MATS.Migration_Certificate.repository.MigrationRepository;
import com.MATS.Migration_Certificate.service.MigrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class MigrationServiceImpl implements MigrationService {

    private final MigrationRepository migrationRepository;
    private final MigrationMapper migrationMapper;

    @Override
    public MigrationResponseDto createMigration(MigrationRequestDto migrationRequestDto) {
        Migration migration = migrationMapper.toMigration(migrationRequestDto);
        migration.setImage();
    }

    @Override
    public MigrationResponseDto getMigration(Long id) {
        return null;
    }

    @Override
    public byte[] generateMigrationCertificate(Long id) {
        return new byte[0];
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
