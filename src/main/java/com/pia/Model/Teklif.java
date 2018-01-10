package com.pia.Model;

import javax.persistence.*;

/**
 * Created by ali on 26.12.2017.
 */

@Entity(name = "teklifler")
public class Teklif {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int offerId;

    @Column (name = "RESTORANID")
    private int restoranId;

    @Column(name = "RESTORANNAME")
    private String restoranName;

    @Column(name = "KISIID")
    private int kisiId;

    @Column(name = "KISINAME")
    private String kisiName;

    public Teklif() {
    }

    public Teklif(int restoranId, String restoranName, int kisiId, String kisiName, int offerId) {
        this.restoranId = restoranId;
        this.restoranName = restoranName;
        this.kisiId = kisiId;
        this.kisiName = kisiName;
        this.offerId = offerId;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getKisiId() {
        return kisiId;
    }

    public void setKisiId(int kisiId) {
        this.kisiId = kisiId;
    }

    public int getRestoranId() {
        return restoranId;
    }

    public void setRestoranId(int restoranId) {
        this.restoranId = restoranId;
    }

    public String getRestoranName() {
        return restoranName;
    }

    public void setRestoranName(String restoranName) {
        this.restoranName = restoranName;
    }

    public String getKisiName() {
        return kisiName;
    }

    public void setKisiName(String kisiName) {
        this.kisiName = kisiName;
    }
}
