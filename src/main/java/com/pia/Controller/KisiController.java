package com.pia.Controller;

import com.pia.Model.Kisi;
import com.pia.Service.KisiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ali on 25.12.2017.
 */

@Controller
public class KisiController {

    @Autowired
    private KisiService kisiService;

    @RequestMapping(value = "kisiler", method = RequestMethod.GET)
    public String kisiler(ModelMap modelMap){

        modelMap.addAttribute("kisiler",kisiService.allKisi());
        return "pages/kisiler";
    }

    @RequestMapping(value = "kisi_ekle", method = RequestMethod.GET)
    public String addKisi(){

        return "pages/kisi_ekle";
    }

    @RequestMapping(value = "kisi_olustur", method = RequestMethod.POST)
    public String addKisi(@ModelAttribute Kisi kisi){

        kisiService.addKisi(kisi);
        return  "redirect:pages/kisiler";
    }

    @RequestMapping(value = "kisi_guncelle", method = RequestMethod.GET)
    public ModelAndView updateKisi(@RequestParam (name="kisi") String id){

        int ids = Integer.valueOf(id);
        ModelAndView modelAndView = new ModelAndView("pages/kisi_guncelle");
        modelAndView.addObject("kisi", kisiService.findOne(ids));
        return modelAndView;
    }

    @RequestMapping(value = "kisiguncelle", method = RequestMethod.GET)
    public String updateKisi(@ModelAttribute Kisi kisi){

        kisiService.updateKisi(kisi);
        return "redirect:kisiler";
    }

    @RequestMapping(value = "kisi_sil", method = RequestMethod.GET)
    public String deleteKisi(@RequestParam(name = "id") String id){
        int ids = Integer.valueOf(id);
        kisiService.deleteKisi(ids);
        return "redirect:kisiler";
    }

    
}
