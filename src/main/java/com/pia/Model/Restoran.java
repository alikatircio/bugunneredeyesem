package com.pia.Model;

import javax.persistence.*;

/**
 * Created by ali on 14.12.2017.
 */

@Entity(name = "restoran")
public class Restoran {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //otomatik id oluşturacak
    private int id;

    @Column(name = "NAME")// kolon adı
    private String name;

    public Restoran(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Restoran() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
