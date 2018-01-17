package com.pia.Controller;

import com.pia.Model.Kisi;
import com.pia.Model.Restoran;
import com.pia.Service.RestoranService;
import org.codehaus.groovy.runtime.powerassert.SourceText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by ali on 14.12.2017.
 */

@Controller
public class RestoranController {

    @Autowired
    private RestoranService restoranService;

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index() {

        return "pages/index";
    }

    @RequestMapping(value = "restoranlar",method = RequestMethod.GET)
    public String getAllRestoran(HttpServletRequest req) {
        req.setAttribute("restoranlar", restoranService.findAllRestoran());
        return "pages/restoranlar";
    }


    @RequestMapping(value = "/yenirestoran", method = RequestMethod.GET)
    public String addRestoran(HttpServletRequest req){
            return  "/pages/yenirestoran";
    }

    @RequestMapping(value = "yenirestoran/create", method = RequestMethod.POST)
    public String  addRestoran(@ModelAttribute Restoran restoran){

        restoranService.addRestoran(restoran);
        return  "redirect:restoranlar";
    }

    @RequestMapping(value = "/sil", method = RequestMethod.GET)
    public String deleteRestoran(@RequestParam(name="id")String id){
        int ids = Integer.valueOf(id);
        System.out.println(id);
        restoranService.deleteRestoran(ids);
        return "redirect:restoranlar";
    }

    @RequestMapping(value = "updaterestoran", method = RequestMethod.GET)
    public ModelAndView updateRestoranPage(@RequestParam(name="restoran") String id){
        int ids = Integer.valueOf(id);
        ModelAndView model = new ModelAndView("pages/guncellerestoran");
        model.addObject("restoran",  restoranService.findOne(ids));
        return model;
    }

    @RequestMapping(value = "/guncelle", method = RequestMethod.GET)
    public String updateRestoran(@ModelAttribute Restoran restoran){

        restoranService.updateRestoran(restoran);
        return "redirect:restoranlar";
    }


    @RequestMapping(value = "restoranbul", method = RequestMethod.GET)
    public ModelAndView restoranBul( HttpSession session){

        Kisi kisi = (Kisi) session.getAttribute("kisi");
        if (kisi.getRole().equalsIgnoreCase("admin")){
            ModelAndView model = new ModelAndView("pages/admin/rasgelerestoran");
            model.addObject("restoranlar",restoranService.randomRestoran());
            return model;
        }
        else {

            ModelAndView model = new ModelAndView("pages/user/rasgelerestoran");
            model.addObject("restoranlar",restoranService.randomRestoran());
            return model;
        }

    }
}