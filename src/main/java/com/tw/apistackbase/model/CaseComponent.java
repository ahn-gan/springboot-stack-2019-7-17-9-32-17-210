package com.tw.apistackbase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CaseComponent {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "objectiveElementDescript", nullable = false)
    private String objectiveElementDescript;

    @Column(name = "subjectiveElementDescript", nullable = false)
    private String subjectiveElementDescript;

    public CaseComponent() {
    }

    public CaseComponent(String objectiveElementDescript, String subjectiveElementDescript) {
        this.objectiveElementDescript = objectiveElementDescript;
        this.subjectiveElementDescript = subjectiveElementDescript;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getObjectiveElementDescript() {
        return objectiveElementDescript;
    }

    public void setObjectiveElementDescript(String objectiveElementDescript) {
        this.objectiveElementDescript = objectiveElementDescript;
    }

    public String getSubjectiveElementDescript() {
        return subjectiveElementDescript;
    }

    public void setSubjectiveElementDescript(String subjectiveElementDescript) {
        this.subjectiveElementDescript = subjectiveElementDescript;
    }
}
