package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CaseComponent;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CaseComponentRepositoryTest {

    @Autowired
    private CaseComponentRepository caseComponentRepository;

    List<CaseComponent> caseComponents;

    @Before
    public void setUp() {
        caseComponents = new ArrayList<>();
        caseComponents.add(new CaseComponent("objective-description-1", "subjective-description-1"));
        caseComponents.add(new CaseComponent("objective-description-2", "subjective-description-2"));
        caseComponents.add(new CaseComponent("objective-description-3", "subjective-description-3"));
        caseComponentRepository.saveAll(caseComponents);
    }

    @Test
    public void should_return_case_component_when_find_by_id() {
        CaseComponent caseComponent = caseComponentRepository.findById(Long.valueOf(1)).orElse(null);
        Assertions.assertEquals(caseComponent.getId(), 1);
    }

}