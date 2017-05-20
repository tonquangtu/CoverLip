package com.clteam.security.listener;

import com.clteam.dataobject.AccountEntity;
import com.clteam.security.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by Khanh Nguyen on 18/5/2017.
 */
@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {

    @Autowired
    private SignUpService signUpService;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private Environment env;

    @Override
    public void onApplicationEvent(final OnRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }

    private void confirmRegistration(final OnRegistrationCompleteEvent event) {
        System.out.println("### Begin send mail confirm");
        final AccountEntity account = event.getAccount();
        final String token = UUID.randomUUID().toString();
        int result = signUpService.createVerificationToken(account, token);
        if (result != -1) {
            final SimpleMailMessage email = createEmailMessage(event, account, token);
            mailSender.send(email);
        } else {

        }
    }

    private SimpleMailMessage createEmailMessage(OnRegistrationCompleteEvent event, AccountEntity account, String token) {
        final String recipientAddress = account.getUsername();
        final String subject = "Registration Confirmation";
        final String confirmationUrl = event.getAppUrl() + "/signup/registrationConfirm?token=" + token;
        final String message = messageSource.getMessage("message.registrationSuccess", null, null);
        final SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + " \r\n" + confirmationUrl);
        email.setFrom(env.getProperty("support.email"));
        return email;
    }

}
