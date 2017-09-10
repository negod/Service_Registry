package se.backede.service.registry;

import java.util.Set;
import javax.ejb.Singleton;
import javax.ws.rs.core.Application;

/**
 *
 * @author Joakim Johansson ( joakimjohansson@outlook.com )
 */
@Singleton
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(se.backede.service.registry.CorsFilter.class);
        resources.add(se.backede.service.registry.boundary.Registry.class);
        resources.add(se.backede.service.registry.boundary.Swagger.class);
        resources.add(se.backede.service.registry.security.Auth.class);
        resources.add(se.backede.webservice.registry.HealthCheck.class);
        resources.add(se.backede.webservice.security.AuthenticationFilter.class);
    }

}
