package com.pia.Controller;

import com.pia.Model.Kisi;
import com.pia.Service.KisiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by ali on 17.01.2018.
 */

@Controller
public class LoginController {

    @Autowired
    KisiService kisiService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(){

        return "pages/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginUser(@ModelAttribute("kisi") Kisi kisi, ModelMap modelMap, HttpSession session){

        if (kisiService.findByEmailAndPassword(kisi.getEmail(), kisi.getPassword()) == null){

            modelMap.put("error", "Kullanıcı bulunamadı");
            return "pages/login";
        }
        else {

            Kisi sessionKisi = kisiService.findByEmail(kisi.getEmail());
            session.setAttribute("kisi", sessionKisi);
            return "redirect:index";
        }
    }

}
