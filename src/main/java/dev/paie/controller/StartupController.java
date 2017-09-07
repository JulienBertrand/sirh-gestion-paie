package dev.paie.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import dev.paie.service.InitialiserDonneesService;

@Controller
public class StartupController {
	@Autowired
	private InitialiserDonneesService initService;

	private static final Logger LOGGER = LoggerFactory.getLogger(StartupController.class);

	@EventListener(ContextRefreshedEvent.class)
	public void ContextRefreshedEvent() {

		LOGGER.info("initialisation des données");

		initService.initialiser();
	}

}
