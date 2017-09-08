package dev.paie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
// Import de la configuration XML dans une configuration Java
//@ImportResource("classpath:jdd-config.xml")
@ImportResource({ "classpath:cotisations-imposables.xml", "classpath:cotisations-non-imposables.xml",
	"classpath:entreprises.xml", "classpath:grades.xml", "classpath:profils-remuneration.xml" })
public class JeuxDeDonneesConfig {
}