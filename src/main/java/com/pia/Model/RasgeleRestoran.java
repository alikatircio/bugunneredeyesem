package com.pia.Model;

/**
 * Created by ali on 26.12.2017.
 */
public class RasgeleRestoran {

    private int restoranId;
    private String restoranName;
    private String kisiName;

    public RasgeleRestoran() {
    }

    public RasgeleRestoran(int restoranId, String restoranName, String kisiName) {
        this.restoranId = restoranId;
        this.restoranName = restoranName;
        this.kisiName = kisiName;
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
