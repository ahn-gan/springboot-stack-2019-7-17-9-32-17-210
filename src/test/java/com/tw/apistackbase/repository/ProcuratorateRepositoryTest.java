package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Procuratorate;
import com.tw.apistackbase.model.Prosecutor;
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
public class ProcuratorateRepositoryTest {
    
    @Autowired
    private ProcuratorateRepository procuratorateRepository;

    @Test
    public void should_return_procuratorate_with_prosecutors_when_set_prosecutors_to_it() {
        Procuratorate procuratorate = new Procuratorate("procuratorate-name");
        List<Prosecutor> prosecutors = new ArrayList<>();
        prosecutors.add(new Prosecutor("Ahn"));
        prosecutors.add(new Prosecutor("Cindy"));
        procuratorate.setProsecutors(prosecutors);
        procuratorateRepository.save(procuratorate);
        Assertions.assertArrayEquals(procuratorate.getProsecutors().toArray(), prosecutors.toArray());

    }
}