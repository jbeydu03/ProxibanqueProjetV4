package org.proxibanque.persistence;

import org.proxibanque.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface permettant la sauvegarde en base de données des comptes clients de la société Proxibanque
 * 
 * @author Jean-Michel HILTBRUNNER, Jean-Baptiste BLANC, Sebastien JOUMARD
 *
 */
public interface DaoCompte extends JpaRepository<Compte, Long> {
	
	public Compte findByNumero(String numero);

}
