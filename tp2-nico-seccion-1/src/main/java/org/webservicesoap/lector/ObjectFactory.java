//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.04.07 a las 11:27:42 PM ART 
//


package org.webservicesoap.lector;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.webservicesoap.lector package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.webservicesoap.lector
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Lector }
     * 
     */
    public Lector createLector() {
        return new Lector();
    }

    /**
     * Create an instance of {@link LectorResponse }
     * 
     */
    public LectorResponse createLectorResponse() {
        return new LectorResponse();
    }

}
