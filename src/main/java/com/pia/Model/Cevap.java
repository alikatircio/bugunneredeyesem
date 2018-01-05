package com.pia.Model;

/**
 * Created by ali on 5.01.2018.
 */
public class Cevap {

    private String kisiEmail;
    private String restoranId;
    private String restoranName;

    public Cevap() {
    }

    public Cevap(String kisiEmail, String restoranId, String restoranName) {
        this.kisiEmail = kisiEmail;
        this.restoranId = restoranId;
        this.restoranName = restoranName;
    }

    public String getKisiEmail() {
        return kisiEmail;
    }

    public void setKisiEmail(String kisiEmail) {
        this.kisiEmail = kisiEmail;
    }

    public String getRestoranId() {
        return restoranId;
    }

    public void setRestoranId(String restoranId) {
        this.restoranId = restoranId;
    }

    public String getRestoranName() {
        return restoranName;
    }

    public void setRestoranName(String restoranName) {
        this.restoranName = restoranName;
    }
}
