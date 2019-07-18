package com.tw.apistackbase.model;

import javax.persistence.*;

@Entity
public class Prosecutor {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToOne
    private Procuratorate procuratorate;

    public Prosecutor() {
    }

    public Prosecutor(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Procuratorate getProcuratorate() {
        return procuratorate;
    }

    public void setProcuratorate(Procuratorate procuratorate) {
        this.procuratorate = procuratorate;
    }
}
