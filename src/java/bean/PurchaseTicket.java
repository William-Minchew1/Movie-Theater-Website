/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Will
 */
@Named(value = "purchaseTicket")
@RequestScoped
public class PurchaseTicket {

    /**
     * Creates a new instance of PurchaseTicket
     */
    public PurchaseTicket() {
    }
    
    public void validateZip(FacesContext context, UIComponent toValidate,
        Object value) throws ValidatorException {
        String zip = (String) value;
        String regex = "\\d{5}";
        if(zip.matches(regex)){
            
        }
        else{
            FacesMessage message = new FacesMessage("Please enter a 5 digit zip");
            throw new ValidatorException(message);
        }
    }
}
