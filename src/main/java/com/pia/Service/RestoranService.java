package com.pia.Service;

import com.pia.DAO.RestoranRepository;
import com.pia.Model.Kisi;
import com.pia.Model.Teklif;
import com.pia.Model.Restoran;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by ali on 14.12.2017.
 */

@Service
public class RestoranService {

    @Autowired
    private RestoranRepository restoranRepository;

    @Autowired
    private KisiService kisiService;

    @Autowired
    private TeklifService teklifService;

    public List<Teklif>  cikanRestoranlar = new ArrayList<>();

    public Collection<Restoran> findAllRestoran(){

        List<Restoran> restorans = new ArrayList<>();
        for (Restoran restoran : restoranRepository.findAll()) {

            restorans.add(restoran);
        }
        return restorans;
    }

    public Restoran findOne(int id){

        return restoranRepository.findOne(id);
    }

    public void addRestoran(Restoran restoran){

        restoranRepository.save(restoran);
    }

    public void deleteRestoran(int id){

        restoranRepository.delete(id);
    }

    public void updateRestoran(Restoran restoran){

        restoranRepository.save(restoran);
    }

    public List<Teklif> randomRestoran(){

        List<Teklif>  rasgeleRestoranlar = new ArrayList<>();
        List<Kisi> kisis = kisiService.allKisi();
        List<Restoran> restorans = new ArrayList<>();
        for (Restoran restoran : restoranRepository.findAll()) {

            restorans.add(restoran);
        }
        for (int i = 0; i<kisis.size(); i++){
            Teklif teklif = new Teklif();
            Random ran =  new Random();
            int restoranIndex = ran.nextInt(restorans.size() + 1);
            if (restoranIndex == 0){
                restoranIndex = ran.nextInt(restorans.size() + 1);
            }
            Restoran bulunanRestoran = findOne(restoranIndex);
            teklif.setRestoranId(bulunanRestoran.getId());
            teklif.setRestoranName(bulunanRestoran.getName());
            teklif.setKisiId(kisis.get(i).getId());
            teklif.setKisiName(kisis.get(i).getName());
            teklifService.addTeklif(teklif);
            rasgeleRestoranlar.add(teklif);

        }
        Collections.sort(rasgeleRestoranlar, new Comparator<Teklif>() {
            @Override
            public int compare(Teklif o1, Teklif o2) {
                return o1.getRestoranId()-o2.getRestoranId();
            }
        });
        cikanRestoranlar = rasgeleRestoranlar;
        return cikanRestoranlar;
    }
}
