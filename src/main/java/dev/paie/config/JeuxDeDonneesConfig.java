package dev.paie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
@Component
@Configuration
//Import de la configuration XML dans une configuration Java
@ImportResource("classpath:jdd-config.xml")
public class JeuxDeDonneesConfig {
}