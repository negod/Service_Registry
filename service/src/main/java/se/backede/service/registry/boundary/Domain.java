/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.backede.service.registry.boundary;

import com.negod.generics.persistence.GenericDao;
import io.swagger.annotations.Api;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import se.backede.service.registry.control.DomainDao;
import se.backede.service.registry.entity.DomainEntity;
import se.backede.webservice.service.RestService;

/**
 *
 * @author Joakim Backede ( joakim.backede@outlook.com )
 */
@Api
@Path("/domain")
public class Domain implements RestService<DomainEntity> {

    @EJB
    DomainDao dao;

    @Override
    public GenericDao getDao() {
        return dao;
    }

}
