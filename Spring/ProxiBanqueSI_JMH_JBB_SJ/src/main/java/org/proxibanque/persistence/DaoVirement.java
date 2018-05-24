package org.proxibanque.persistence;

import org.proxibanque.model.Virement;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface permettant la gestion en base de données des virements entre
 * comptes de la société Proxibanque
 * 
 * @author Jean-Michel HILTBRUNNER, Jean-Baptiste BLANC, Sebastien JOUMARD
 *
 */
public interface DaoVirement extends JpaRepository<Virement, Long> {

}
