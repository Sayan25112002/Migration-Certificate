package com.MATS.Migration_Certificate.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MigrationResponseDto {

    private Long id;

    private String migrationNumber;

    private String image;

    private String date;

    private String name;

    private String fatherName;

    private String motherName;

    private String applicationNumber;

    private String enrollmentNumber;

    private String course;

    private String year;

    private String naam;

    private String papaKaNaam;

    private String maaKaNaam;

    private String shiksha;

    private String qrCode;

    private String controllerOfExamination;

    private String registrar;

    private String verifiedDate;

    private String certificateDate;

}
