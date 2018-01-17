package com.pia.Service;

import com.pia.DAO.KisiRepository;
import com.pia.Model.Kisi;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Created by ali on 25.12.2017.
 */

@Service
public class KisiService {

    @Autowired
    private KisiRepository kisiRepository;

    public void addKisi(Kisi kisi){

        kisiRepository.save(kisi);
    }


    public int randomKisi(){

        Random ran =  new Random();
        List<Kisi> kisis = new ArrayList<>();
        for (Kisi kisi : kisiRepository.findAll()) {

            kisis.add(kisi);
        }
        int kisiIndex = ran.nextInt(kisis.size()+1);
        return kisiIndex;
    }

    public Kisi findOne(int id){

        return kisiRepository.findOne(id);
    }

    public List<Kisi> allKisi(){

        List<Kisi> kisis = new ArrayList<>();
        for (Kisi kisi : kisiRepository.findAll()) {

            kisis.add(kisi);
        }
        return kisis;
    }

    public void updateKisi(Kisi kisi){

       kisiRepository.save(kisi);
    }

    public void deleteKisi(int id){

        kisiRepository.delete(id);
    }

    public Kisi findByEmail(String email){

        return kisiRepository.findByEmail(email);
    }

    public Kisi findByEmailAndPassword (String email, String password){

        return kisiRepository.findByEmailAndPassword(email, password);
    }
}
