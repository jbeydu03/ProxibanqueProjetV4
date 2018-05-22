package org.proxibanque.persistence;

import java.util.List;

import org.proxibanque.model.Client;
import org.proxibanque.model.Conseiller;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface permettant la sauvegarde en base de données des clients de la société Proxibanque
 * 
 * @author Jean-Michel HILTBRUNNER, Jean-Baptiste BLANC, Sebastien JOUMARD
 *
 */
public interface DaoClient extends JpaRepository<Client, Long> {

	
	public List<Client> findByConseiller_idIs(long idConseiller);
	
}
