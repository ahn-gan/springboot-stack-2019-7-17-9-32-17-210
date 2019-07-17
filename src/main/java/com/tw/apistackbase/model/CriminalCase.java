package com.tw.apistackbase.model;

import javax.persistence.*;

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
}
