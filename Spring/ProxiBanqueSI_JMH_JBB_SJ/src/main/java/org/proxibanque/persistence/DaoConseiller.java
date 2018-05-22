package org.proxibanque.persistence;

import org.proxibanque.model.Conseiller;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface permettant la sauvegarde en base de données des conseillers de la société Proxibanque
 * 
 * @author Jean-Michel HILTBRUNNER, Jean-Baptiste BLANC, Sebastien JOUMARD
 *
 */
public interface DaoConseiller extends JpaRepository<Conseiller, Long>  {

	public Conseiller findByNomIs(String nomConseiller);
}
