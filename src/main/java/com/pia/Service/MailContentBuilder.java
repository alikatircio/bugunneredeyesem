package com.pia.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * Created by ali on 4.01.2018.
 */

@Service
public class MailContentBuilder {

    private TemplateEngine templateEngine;

    @Autowired
    public MailContentBuilder(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String build(String name, String restoran) {
        Context context = new Context();
        context.setVariable("name", name);
        context.setVariable("restoran", restoran);
        return templateEngine.process("pages/email", context);
    }
}