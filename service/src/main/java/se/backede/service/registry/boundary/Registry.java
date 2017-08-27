package se.backede.service.registry.boundary;

import io.swagger.annotations.Api;
import se.backede.service.registry.control.RegistryDao;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author Joakim Backede ( joakim.backede@outlook.com )
 */
@Api
@Path("/registry")
public class Registry {

    @EJB
    RegistryDao dao;

}
