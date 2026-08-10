package com.MATS.Migration_Certificate.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MigrationRequestDto {

    private String image;

    private String imageFile;

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

    private String aavedanSankhya;

    private String namanthinSankhya;

    private String saal;

    private String shiksha;

    private String controllerOfExamination;

    private String registrar;

    private String verifiedDate;

    private String certificateDate;

}
