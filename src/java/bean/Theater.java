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

/**
 *
 * @author Will
 */
@Named(value = "theater")
@RequestScoped
public class Theater {

    @EJB
    private TheaterEJB theaterEJB;
    private List<Theaters> theater;
    private String zip;

    /**
     * Creates a new instance of Theater
     */
    public Theater() {
        zip = "";
    }

    public List<Theaters> getTheater() {
        return theater;
    }

    public void setTheater(List<Theaters> theater) {
        this.theater = (List<Theaters>) theater;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
    public String showTheater(){
        this.theater = theaterEJB.getTheater(zip);
        return "ShowTheater.xhtml";
    }
    
    public List<Theaters> getTheaterList(){
        return theaterEJB.getTheater(zip);
    }
    
    public String returnToZip(){
        return "index.xhtml";
    }
}
