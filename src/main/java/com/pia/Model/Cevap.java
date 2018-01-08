package com.pia.Model;

import javax.persistence.*;

/**
 * Created by ali on 5.01.2018.
 */

@Entity(name = "cevap")
public class Cevap {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "KISIEMAIL")
    private String kisiEmail;

    @Column(name = "RESTORANNAME")
    private String restoranName;

    @Column(name = "GIDIRYOR")
    private boolean gidiyor;

    @Column(name = "PAHALI")
    private boolean pahali;

    @Column(name = "TICKET")
    private boolean ticket;

    @Column(name = "YAGLI")
    private boolean yagli;

    @Column(name = "DESCRIPTION")
    private String description;


    public Cevap() {
    }

    public Cevap(String kisiEmail, String restoranName, boolean gidiyor, boolean pahali, boolean ticket, boolean yagli, String description) {
        this.kisiEmail = kisiEmail;
        this.restoranName = restoranName;
        this.gidiyor = gidiyor;
        this.pahali = pahali;
        this.ticket = ticket;
        this.yagli = yagli;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isGidiyor() {
        return gidiyor;
    }

    public void setGidiyor(boolean gidiyor) {
        this.gidiyor = gidiyor;
    }

    public boolean isTicket() {
        return ticket;
    }

    public void setTicket(boolean ticket) {
        this.ticket = ticket;
    }

    public boolean isYagli() {
        return yagli;
    }

    public void setYagli(boolean yagli) {
        this.yagli = yagli;
    }

    public boolean isPahali() {
        return pahali;
    }

    public void setPahali(boolean pahali) {
        this.pahali = pahali;
    }

    public String getKisiEmail() {
        return kisiEmail;
    }

    public void setKisiEmail(String kisiEmail) {
        this.kisiEmail = kisiEmail;
    }

    public String getRestoranName() {
        return restoranName;
    }

    public void setRestoranName(String restoranName) {
        this.restoranName = restoranName;
    }
}
