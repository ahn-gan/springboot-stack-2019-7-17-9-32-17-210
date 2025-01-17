package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CaseComponent;
import com.tw.apistackbase.model.CriminalCase;
import com.tw.apistackbase.model.Procuratorate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CriminalCaseRepositoryTest {

    @Autowired
    private CriminalCaseRepository criminalCaseRepository;

    List<CriminalCase> criminalCases;

    @Before
    public void setUp() {
        criminalCases = new ArrayList<>();
        criminalCases.add(new CriminalCase("test-case-1", 1600, new CaseComponent("case1-objective-name", "case1-subjective-name"), new Procuratorate("procu1-name")));
        criminalCases.add(new CriminalCase("test-case-2", 1700, new CaseComponent("case2-objective-name", "case2-subjective-name"), new Procuratorate("procu2-name")));
        criminalCases.add(new CriminalCase("test-case-3", 1800, new CaseComponent("case3-objective-name", "case3-subjective-name"), new Procuratorate("procu3-name")));
        criminalCaseRepository.saveAll(criminalCases);
    }

    @Test
    public void should_return_all_criminal_cases_when_find_all() {
        List<CriminalCase> findCriminalCases = criminalCaseRepository.findAll();
        Assertions.assertEquals(findCriminalCases.size(), 3);
    }

    @Test
    public void should_return_all_criminal_cases_order_by_time_desc_when_find_all_with_order() {
        List<CriminalCase> findCriminalCases = criminalCaseRepository.findAllByOrderByOccurrenceTimeDesc();
        Assertions.assertEquals(findCriminalCases.get(0).getOccurrenceTime(), 1800);
    }

    @Test
    public void should_criminal_cases_when_find_by_name() {
        List<CriminalCase> findCriminalCases = criminalCaseRepository.findAllByCaseName("test-case-1");
        Assertions.assertEquals(findCriminalCases.get(0).getCaseName(), "test-case-1");
    }

    @Test
    public void should_delete_count_when_delete_by_id() {
        criminalCaseRepository.deleteById(Long.valueOf(1));
        List<CriminalCase> findCriminalCases = criminalCaseRepository.findAll();
        Assertions.assertEquals(findCriminalCases.size(), 2);
    }

    @Test
    public void should_return_criminal_case_with_detail_when_set_details_to_it() {
        CaseComponent caseComponent = new CaseComponent("objective-description-1", "subjective-description-1");
        CriminalCase criminalCase = new CriminalCase("test-case-new", 1600);
        criminalCase.setCaseComponents(caseComponent);
        CriminalCase saveCriminalCase =  criminalCaseRepository.save(criminalCase);
        Assertions.assertSame(saveCriminalCase.getCaseComponents(), caseComponent);
    }

    @Test
    public void should_return_criminal_case_with_procuratortate_when_set_procuratortate_to_it() {
        Procuratorate procuratorate = new Procuratorate("AHN");
        CriminalCase criminalCase = new CriminalCase("test-case-new", 1600);
        criminalCase.setProcuratorate(procuratorate);
        CriminalCase saveCriminalCase =  criminalCaseRepository.save(criminalCase);
        Assertions.assertSame(saveCriminalCase.getProcuratorate(), procuratorate);
    }
}