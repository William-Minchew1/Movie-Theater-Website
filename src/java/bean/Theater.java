/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.TheaterEJB;
import entity.Theaters;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Will
 */
@Named(value = "theater")
@SessionScoped
public class Theater implements Serializable{

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
        this.theater = theaterEJB.getTheater(this.zip);
        return "ShowTheater.xhtml?faces-redirect=true";
    }
    
    public String getTheaterName(){
        return theater.get(0).getTheatername();
    }
    
    public String getTheaterAddress(){
        return theater.get(0).getTheateraddress();
    }
    
    public List<Theaters> getTheaterList(){
        if(!zip.equals(""))
            return theaterEJB.getTheater(zip);
        else
            return null;
    }
    
    public String returnToZip(){
        return "index.xhtml";
    }
    
    public void clear(){
        this.theater = theaterEJB.getTheater("75034");
        zip = "";
    }
}
