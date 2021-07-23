/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.TheaterEJB;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Will
 */
@Named(value = "theater")
@RequestScoped
public class Theater {

    @EJB
    private TheaterEJB theaterEJB;

    /**
     * Creates a new instance of Theater
     */
    public Theater() {
    }
    
}
