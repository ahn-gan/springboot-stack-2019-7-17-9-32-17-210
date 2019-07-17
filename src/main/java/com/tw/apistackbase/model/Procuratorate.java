package com.tw.apistackbase.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Procuratorate {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Prosecutor> prosecutors;

    public Procuratorate() {
    }

    public Procuratorate(String name) {
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

    public List<Prosecutor> getProsecutors() {
        return prosecutors;
    }

    public void setProsecutors(List<Prosecutor> prosecutors) {
        this.prosecutors = prosecutors;
    }
}
