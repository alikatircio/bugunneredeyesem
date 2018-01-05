package com.pia.Controller;

import com.pia.Model.Cevap;
import com.pia.Model.Kisi;
import com.pia.Model.Mail;
import com.pia.Service.KisiService;
import com.pia.Service.MailService;
import com.sun.tracing.dtrace.ModuleAttributes;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.List;

/**
 * Created by ali on 5.01.2018.
 */

@Controller
public class MailController {

    @Autowired
    private KisiService kisiService;

    @Autowired
    private MailService mailService;

    @RequestMapping(value = "mail_gonder", method = RequestMethod.GET)
    public String sendRandomMail() throws MessagingException, IOException, javax.mail.MessagingException {

        List<Mail> kisiAndRestoranList = mailService.findKisiAndRestoran();
        for (int i = 0; i<kisiAndRestoranList.size(); i++){

            String email = kisiAndRestoranList.get(i).getKisiEmail();
            Kisi kisi = kisiService.findByEmail(email);
            String kisiName = kisi.getName();
            String restoranName = kisiAndRestoranList.get(i).getRestoranName();
            mailService.sendEmail(kisiName, email, restoranName);
        }

        return "redirect:/";
    }

    @RequestMapping(value = "evet", method = RequestMethod.GET)
    public String answerEvet(){

        System.out.println("ali");
        return "redirect:/";
    }

    @RequestMapping(value = "hayir", method = RequestMethod.GET)
    public String answeHayır(){

        return "pages/hayirform";
    }

    @RequestMapping(value = "sebep", method = RequestMethod.GET)
    public String hayir(@ModelAttribute Cevap cevap){

        System.out.println(cevap.getKisiEmail());
        return "";
    }
}
