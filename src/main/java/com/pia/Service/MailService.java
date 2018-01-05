package com.pia.Service;

import com.pia.Model.Kisi;
import com.pia.Model.Mail;
import com.pia.Model.RasgeleRestoran;
import com.pia.Model.Restoran;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ali on 3.01.2018.
 */

@Service
public class MailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Autowired
    private RestoranService restoranService;

    @Autowired
    private KisiService kisiService;

    @Autowired
    private MailContentBuilder mailContentBuilder;

    public void sendEmail(String name, String recipient, String restoran) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
        messageHelper.setFrom("prm-test@pia-team.com");
        messageHelper.setTo(recipient);
        messageHelper.setSubject("Bugün Nerede Yesem?");
        String content = mailContentBuilder.build(name, restoran);
        messageHelper.setText(content, true);
        try {
            javaMailSender.send(mimeMessage);
        }catch (MailException e){

        }
    }

    public List<Mail> findKisiAndRestoran(){

        List<RasgeleRestoran> rasgeleRestorans = restoranService.cikanRestoranlar;
        List<Mail> kisiAndRestonList = new ArrayList<>();
        for (int i = 0; i<rasgeleRestorans.size(); i++){

            Mail mail = new Mail();
            int kisiId = rasgeleRestorans.get(i).getKisiId();
            int restoranId = rasgeleRestorans.get(i).getRestoranId();
            Kisi kisi = kisiService.findOne(kisiId);
            Restoran restoran = restoranService.findOne(restoranId);
            mail.setKisiId(kisi.getId());
            mail.setKisiEmail(kisi.getEmail());
            mail.setRestoranId(restoran.getId());
            mail.setRestoranName(restoran.getName());
            kisiAndRestonList.add(mail);
        }
        return kisiAndRestonList;
    }
}
