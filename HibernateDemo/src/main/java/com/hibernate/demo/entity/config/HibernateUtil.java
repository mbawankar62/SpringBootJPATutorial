package com.hibernate.demo.entity.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
Next, let's create a helper class to bootstrap hibernate SessionFactory. In most Hibernate applications, 
the SessionFactory should be instantiated once during application initialization.
 The single instance should then be used by all code in a particular process, and any Session should be 
 created using this single SessionFactory. The SessionFactory is thread-safe and can be shared.
Let's create HibernateUtil class with the following code to configure SessionFactory as a singleton and
 use it throughout the application: **/
public class HibernateUtil {

	private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
            	
            	//The configure() method is called on the StandardServiceRegistryBuilder to load the
            	//hibernate.cfg.xml file and configure Hibernate settings, such as the database driver, URL, username, password, and dialect.
                // Create registry
                registry = new StandardServiceRegistryBuilder().configure().build();

                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);

                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();

                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();
                
              /*  ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                    sessionFactory = configuration.buildSessionFactory(serviceRegistry);*/

            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
