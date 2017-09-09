package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class BulletinSalaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "ID_REMU")
	private RemunerationEmploye remunerationEmploye;
	@ManyToOne
	@JoinColumn(name = "ID_PERIODE")
	private Periode periode;
	@Column(name = "PRIME_EXCEP")
	private BigDecimal primeExceptionnelle;
	@Transient
	private ResultatCalculRemuneration resultatCalculRemuneration;

	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}

	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}

	public Periode getPeriode() {
		return periode;
	}

	public void setPeriode(Periode periode) {
		this.periode = periode;
	}

	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}

	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the resultatCalculRemuneration
	 */
	public ResultatCalculRemuneration getResultatCalculRemuneration() {
		return resultatCalculRemuneration;
	}

	/**
	 * @param resultatCalculRemuneration the resultatCalculRemuneration to set
	 */
	public void setResultatCalculRemuneration(ResultatCalculRemuneration resultatCalculRemuneration) {
		this.resultatCalculRemuneration = resultatCalculRemuneration;
	}

}
