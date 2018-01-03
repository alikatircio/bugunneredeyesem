package com.pia.Model;

import org.springframework.ui.Model;

/**
 * Created by ali on 3.01.2018.
 */
public class Mail {

    private int kisiId;
    private String kisiEmail;
    private int restoranId;
    private String restoranName;
    private Model model;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Mail() {
    }

    public Mail(int kisiId, String kisiName, int restoranId, String restoranName) {
        this.kisiId = kisiId;
        this.kisiEmail = kisiName;
        this.restoranId = restoranId;
        this.restoranName = restoranName;
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
