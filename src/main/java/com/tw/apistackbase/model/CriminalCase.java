package com.tw.apistackbase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CriminalCase {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "occurenceTime", nullable = false)
    private long occurrenceTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(long occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }
}
