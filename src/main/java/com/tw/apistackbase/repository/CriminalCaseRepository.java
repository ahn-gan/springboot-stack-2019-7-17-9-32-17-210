package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CriminalCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CriminalCaseRepository extends JpaRepository<CriminalCase, Long> {

    List<CriminalCase> findAllByOrderByOccurrenceTimeDesc();

    List<CriminalCase> findAllByCaseName(String caseName);
}
