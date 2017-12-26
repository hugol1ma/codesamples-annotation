package codesample.config;

import codesample.api.ExampleAPI;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hugomartins on 12/26/17.
 */
@ApplicationPath("/api")
public class RestApplication extends Application {

    //Config for swagger
    public RestApplication() {
        BeanConfig conf = new BeanConfig();
        conf.setTitle("Api Example with custom swagger annotation");
        conf.setDescription("Custom Annotation");
        conf.setVersion("1.0.0");
        conf.setHost("localhost:8080");
        conf.setBasePath("/api");
        conf.setSchemes(new String[] { "http" });
        conf.setResourcePackage("codesample.api");
        conf.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<Class<?>>();
        resources.add(ExampleAPI.class);

        resources.add(ApiListingResource.class);

        return super.getClasses();
    }
}
