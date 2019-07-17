package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CriminalCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

//import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CriminalCaseRepositoryTest {

    @Autowired
    private CriminalCaseRepository criminalCaseRepository;

    List<CriminalCase> criminalCases;

    @Before
    public void setUp() {
        criminalCases = new ArrayList<>();
        criminalCases.add(new CriminalCase("test-case-1", 1600));
        criminalCases.add(new CriminalCase("test-case-2", 1700));
        criminalCaseRepository.saveAll(criminalCases);
    }

    @Test
    public void should_return_all_criminal_cases_when_find_all() {
        List<CriminalCase> findCriminalCases = criminalCaseRepository.findAll();
        Assertions.assertEquals(findCriminalCases.size(), 2);
    }

    @Test
    public void should_return_all_criminal_cases_order_by_time_desc_when_find_all_with_order() {
        List<CriminalCase> findCriminalCases = criminalCaseRepository.findAllByOrderByOccurrenceTimeDesc();
        Assertions.assertEquals(findCriminalCases.get(0).getOccurrenceTime(), 1700);
    }


}