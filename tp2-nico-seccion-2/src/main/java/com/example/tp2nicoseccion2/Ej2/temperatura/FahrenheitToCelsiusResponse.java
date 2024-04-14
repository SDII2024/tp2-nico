
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
 *         &lt;element name="FahrenheitToCelsiusResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "fahrenheitToCelsiusResult"
})
@XmlRootElement(name = "FahrenheitToCelsiusResponse")
public class FahrenheitToCelsiusResponse {

    @XmlElement(name = "FahrenheitToCelsiusResult")
    protected String fahrenheitToCelsiusResult;

    /**
     * Obtiene el valor de la propiedad fahrenheitToCelsiusResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFahrenheitToCelsiusResult() {
        return fahrenheitToCelsiusResult;
    }

    /**
     * Define el valor de la propiedad fahrenheitToCelsiusResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFahrenheitToCelsiusResult(String value) {
        this.fahrenheitToCelsiusResult = value;
    }

}
