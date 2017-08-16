package se.backede.service.registry.control;

import com.negod.generics.persistence.GenericDao;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import se.backede.service.registry.entity.RegistryEntity;

/**
 *
 * @author Joakim Backede ( joakim.backede@outlook.com )
 */
@LocalBean
@Stateless
public class RegistryDao extends GenericDao<RegistryEntity> {
}
