package com.pia.Service;

import com.pia.DAO.RestoranRepository;
import com.pia.Model.Kisi;
import com.pia.Model.RasgeleRestoran;
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

    public List<RasgeleRestoran>  cikanRestoranlar = new ArrayList<>();

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

    public List<RasgeleRestoran> randomRestoran(){

        List<RasgeleRestoran>  rasgeleRestoranlar = new ArrayList<>();
        List<Kisi> kisis = kisiService.allKisi();
        List<Restoran> restorans = new ArrayList<>();
        for (Restoran restoran : restoranRepository.findAll()) {

            restorans.add(restoran);
        }
        for (int i = 0; i<kisis.size(); i++){
            RasgeleRestoran rasgeleRestoran = new RasgeleRestoran();
            Random ran =  new Random();
            int restoranIndex = ran.nextInt(restorans.size() + 1);
            if (restoranIndex == 0){
                restoranIndex = ran.nextInt(restorans.size() + 1);
            }
            Restoran bulunanRestoran = findOne(restoranIndex);
            rasgeleRestoran.setRestoranId(bulunanRestoran.getId());
            rasgeleRestoran.setRestoranName(bulunanRestoran.getName());
            rasgeleRestoran.setKisiId(kisis.get(i).getId());
            rasgeleRestoran.setKisiName(kisis.get(i).getName());
            rasgeleRestoranlar.add(rasgeleRestoran);

        }
        Collections.sort(rasgeleRestoranlar, new Comparator<RasgeleRestoran>() {
            @Override
            public int compare(RasgeleRestoran o1, RasgeleRestoran o2) {
                return o1.getRestoranId()-o2.getRestoranId();
            }
        });
        cikanRestoranlar = rasgeleRestoranlar;
        return cikanRestoranlar;
    }
}
