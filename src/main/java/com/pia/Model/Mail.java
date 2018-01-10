package com.pia.Model;

/**
 * Created by ali on 3.01.2018.
 */
public class Mail {

    private int kisiId;
    private String kisiEmail;
    private int restoranId;
    private String restoranName;
    private int offerId;

    public Mail() {
    }

    public Mail(int kisiId, String kisiEmail, int restoranId, String restoranName, int offerId) {
        this.kisiId = kisiId;
        this.kisiEmail = kisiEmail;
        this.restoranId = restoranId;
        this.restoranName = restoranName;
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

    public String getKisiEmail() {
        return kisiEmail;
    }

    public void setKisiEmail(String kisiName) {
        this.kisiEmail = kisiName;
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
}
