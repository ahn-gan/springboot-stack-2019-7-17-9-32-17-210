package com.tw.apistackbase.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class CriminalCase {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "caseName", nullable = false)
    private String caseName;

    @Column(name = "occurenceTime", nullable = false)
    private long occurrenceTime;

    @OneToOne(cascade = CascadeType.ALL)
    private CaseComponent caseComponents;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Procuratorate procuratorate;

    public CriminalCase() {
    }

    public CriminalCase(String caseName, long occurrenceTime) {
        this.caseName = caseName;
        this.occurrenceTime = occurrenceTime;
    }

    public CriminalCase(String caseName, long occurrenceTime, CaseComponent caseComponents) {
        this.caseName = caseName;
        this.occurrenceTime = occurrenceTime;
        this.caseComponents = caseComponents;
    }

    public CriminalCase(String caseName, long occurrenceTime, CaseComponent caseComponents, @NotNull Procuratorate procuratorate) {
        this.caseName = caseName;
        this.occurrenceTime = occurrenceTime;
        this.caseComponents = caseComponents;
        this.procuratorate = procuratorate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public long getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(long occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }

    public CaseComponent getCaseComponents() {
        return caseComponents;
    }

    public void setCaseComponents(CaseComponent caseComponents) {
        this.caseComponents = caseComponents;
    }

    public Procuratorate getProcuratorate() {
        return procuratorate;
    }

    public void setProcuratorate(Procuratorate procuratorate) {
        this.procuratorate = procuratorate;
    }
}
