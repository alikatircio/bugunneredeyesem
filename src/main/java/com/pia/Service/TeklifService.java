package com.pia.Service;

import com.pia.DAO.TeklifRepository;
import com.pia.Model.Restoran;
import com.pia.Model.Teklif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ali on 10.01.2018.
 */

@Service
public class TeklifService {

    @Autowired
    private TeklifRepository teklifRepository;

    public void addTeklif(Teklif teklif){

        teklifRepository.save(teklif);
    }

    public List<Teklif> findAllRestoran(){

        List<Teklif> teklifs = new ArrayList<>();
        for (Teklif teklif : teklifRepository.findAll()) {

            teklifs.add(teklif);
        }
        return teklifs;
    }

}
