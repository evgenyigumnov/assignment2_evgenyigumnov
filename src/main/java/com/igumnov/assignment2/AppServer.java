package com.igumnov.assignment2;

import java.util.Locale;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@EnableAutoConfiguration
@ComponentScan("com.igumnov.assignment2")
@EnableGlobalMethodSecurity(securedEnabled = true)
public class AppServer extends WebMvcConfigurerAdapter {
    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(AppServer.class).run(args);
    }




}