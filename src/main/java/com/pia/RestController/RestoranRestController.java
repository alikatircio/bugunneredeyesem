package com.pia.RestController;

import com.pia.Model.Restoran;
import com.pia.Service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by ali on 15.12.2017.
 */

@RestController
public class RestoranRestController {

    @Autowired
    private RestoranService restoranService;

    @RequestMapping(value = "/restoran", method = RequestMethod.GET)
    public Collection<Restoran> getAllRestoran(){

        return restoranService.findAllRestoran();
    }

   /* @RequestMapping(value = "delete", method = RequestMethod.GET)
    public void deleteRestoran(@RequestParam int id){

        restoranService.delete(id);
    }*/
}
