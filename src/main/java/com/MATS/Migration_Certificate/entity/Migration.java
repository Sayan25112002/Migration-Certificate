package com.MATS.Migration_Certificate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Migration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    private String aavedanSankhya;

    private String namanthinSankhya;

    private String saal;

    private String shiksha;

    private String controllerOfExamination;

    private String registrar;

    private String verifiedDate;

    private String certificateDate;

}
