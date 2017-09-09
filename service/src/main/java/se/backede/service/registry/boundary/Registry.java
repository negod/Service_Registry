package se.backede.service.registry.boundary;

import com.negod.generics.persistence.GenericDao;
import io.swagger.annotations.Api;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import se.backede.service.registry.control.RegistryDao;
import se.backede.service.registry.entity.RegistryEntity;
import se.backede.webservice.service.RestService;

/**
 *
 * @author Joakim Backede ( joakim.backede@outlook.com )
 */
@Api
@Path("/registry")
public class Registry implements RestService<RegistryEntity> {

    @EJB
    RegistryDao dao;

    @Override
    public GenericDao getDao() {
        return dao;
    }

}
