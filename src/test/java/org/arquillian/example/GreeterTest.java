package org.arquillian.example;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.exporter.ZipExporter;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@RunWith(Arquillian.class)
public class GreeterTest {

    @Deployment
    public static WebArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
                .addClasses(InternalGreeter.class, GreeterTest.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

        WebArchive war = ShrinkWrap.create(WebArchive.class).addAsLibrary(jar);

        return war;
    }

    @Inject
    InternalGreeter greeter2;

    @Test
    public void should_create_greeting() {

    }

    @Dependent
    public static class InternalGreeter {
        public String greet() {
            return "";
        }
    }
}
