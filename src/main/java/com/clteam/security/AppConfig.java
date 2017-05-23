package com.clteam.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * Created by Khanh Nguyen on 18/5/2017.
 */
@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Autowired
    private Environment env;

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
        rb.setBasenames("message");
        return rb;
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("mail.host"));
        mailSender.setPort(Integer.parseInt(env.getProperty("mail.port")));
        mailSender.setPassword(env.getProperty("mail.password"));
        mailSender.setUsername(env.getProperty("mail.username"));
        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", env.getProperty("mail.smtp.starttls.enable"));
        javaMailProperties.put("mail.smtp.auth", env.getProperty("mail.smtp.auth"));
        javaMailProperties.put("mail.transport.protocol", env.getProperty("mail.transport.protocol"));
        javaMailProperties.put("mail.debug", env.getProperty("mail.debug"));
        mailSender.setJavaMailProperties(javaMailProperties);
        return mailSender;
    }

}
