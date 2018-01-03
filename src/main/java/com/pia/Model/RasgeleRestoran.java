package com.pia.Model;

/**
 * Created by ali on 26.12.2017.
 */
public class RasgeleRestoran {

    private int restoranId;
    private String restoranName;
    private int kisiId;
    private String kisiName;

    public RasgeleRestoran() {
    }

    public RasgeleRestoran(int restoranId, String restoranName, int kisiId, String kisiName) {
        this.restoranId = restoranId;
        this.restoranName = restoranName;
        this.kisiId = kisiId;
        this.kisiName = kisiName;
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
