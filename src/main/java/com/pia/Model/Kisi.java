package com.pia.Model;

import javax.persistence.*;

/**
 * Created by ali on 25.12.2017.
 */

@Entity(name = "kisi")
public class Kisi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column (name= "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    public Kisi(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Kisi() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
