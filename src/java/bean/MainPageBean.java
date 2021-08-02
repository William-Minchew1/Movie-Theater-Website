/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.TheaterEJB;
import entity.Theaters;
import java.util.List;
import javax.ejb.EJB;
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
@Named(value = "mainPageBean")
@RequestScoped
public class MainPageBean {

    @EJB
    private TheaterEJB theaterEJB;

    /**
     * Creates a new instance of MainPageBean
     */
    public MainPageBean() {
    }
    
    /**
    * Validates that the user enters a 5 digit zip and we have a theater in said zip
     * @param context
     * @param toValidate
     * @param value
    */
    public void validateZip(FacesContext context, UIComponent toValidate,
        Object value) throws ValidatorException {
        String zip = (String) value;
        String regex = "\\d{5}";
        if(zip.matches(regex)){
            if(zip.equals("75034") || zip.equals("75254") || zip.equals(75240)){
            
            }
            else{
                FacesMessage message = new FacesMessage("Sorry there is no theater in that zip");
                throw new ValidatorException(message);
            }
        }
        else{
            FacesMessage message = new FacesMessage("Please enter a 5 digit zip");
            throw new ValidatorException(message);
        }
    }
    
    /**
     * Returns all theaters within our database.
     * @return 
     */
    public List<Theaters> getAllTheaters(){
        return theaterEJB.getAllTheaters();
    }
    
    
}
