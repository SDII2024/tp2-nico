
package com.example.tp2nicoseccion2.Ej2.temperatura;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CelsiusToFahrenheitResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "celsiusToFahrenheitResult"
})
@XmlRootElement(name = "CelsiusToFahrenheitResponse")
public class CelsiusToFahrenheitResponse {

    @XmlElement(name = "CelsiusToFahrenheitResult")
    protected String celsiusToFahrenheitResult;

    /**
     * Obtiene el valor de la propiedad celsiusToFahrenheitResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCelsiusToFahrenheitResult() {
        return celsiusToFahrenheitResult;
    }

    /**
     * Define el valor de la propiedad celsiusToFahrenheitResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCelsiusToFahrenheitResult(String value) {
        this.celsiusToFahrenheitResult = value;
    }

}