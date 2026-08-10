package com.MATS.Migration_Certificate.repository;

import com.MATS.Migration_Certificate.entity.Migration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MigrationRepository extends JpaRepository<Migration,Long> {
}
