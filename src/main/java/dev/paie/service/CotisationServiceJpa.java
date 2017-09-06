package dev.paie.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

@Service

public class CotisationServiceJpa implements CotisationService {
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void sauvegarder(Cotisation nouvelleCotisation) {
		// TODO Auto-generated method stub
		em.persist(nouvelleCotisation);
	}

	@Override
	@Transactional
	public void mettreAJour(Cotisation cotisation) {
		// Cotisation cotisation1= new Cotisation();
		Cotisation cotisation1 = em.find(Cotisation.class, cotisation.getId());
		cotisation1.setCode(cotisation.getCode());
		cotisation1.setLibelle(cotisation.getLibelle());
		cotisation1.setTauxPatronal(cotisation.getTauxPatronal());
		cotisation1.setTauxSalarial(cotisation.getTauxSalarial());

	}

	@Override
	@Transactional
	public List<Cotisation> lister() {
		TypedQuery<Cotisation> query = em.createQuery("SELECT c FROM Cotisation c", Cotisation.class);
		return new ArrayList<Cotisation>(query.getResultList());

	}

	
	@Override
	@Transactional
	public Cotisation findByCode(String code){
		TypedQuery<Cotisation> query = em.createQuery("SELECT c FROM Cotisation c WHERE c.code = :code", Cotisation.class);
		query.setParameter("code", code);
		return query.getSingleResult();
	}
	
	
	
	@Override
	public void truncate() {
		// Query query= em.createQuery("TRUNCATE TABLE Cotisation", Cotisation.class);

	}
}
