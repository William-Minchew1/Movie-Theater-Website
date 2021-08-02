/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.TheaterEJB;
import entity.Theaters;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Will
 */
@Named(value = "theater")
@SessionScoped
public class Theater implements Serializable{

    @EJB
    private TheaterEJB theaterEJB;  // EJB object used to call namedqueries
    private List<Theaters> theater; // List of theaters for a given zip
    private String zip;             // zip given by user
    private int nameCount = 0;      // Counter for 
    private int addCount = 0;

    /**
     * Creates a new instance of Theater
     */
    public Theater() {
        zip = "";
    }
    
    /**
     * Returns list of theaters for a given zip 
     * @return list of theaters
     */
    public List<Theaters> getTheater() {
        return theater;
    }

    /**
     * Sets the list of theaters to the given one
     * @param theater list of theaters
     */
    public void setTheater(List<Theaters> theater) {
        this.theater = (List<Theaters>) theater;
    }

    /**
     * Returns current zip code
     * @return String containing 5 digit zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets current zip to the given one
     * @param zip String containing 5 digit zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }
    
    /**
     * Sets current theater object to the one given by the EJB named query using the zip and
     * returns link to next page
     * @return Link to ShowTheater
     */
    public String showTheater(){
        this.theater = theaterEJB.getTheater(this.zip);
        return "ShowTheater.xhtml?faces-redirect=true";
    }
    
    /**
     * Returns the name of the current in the list looping using nameCount
     * @return Name of theater
     */
    public String getTheaterName(){
        return theater.get(nameCount++).getTheatername();
    }
    
    /**
     * Returns the address of the current in the list looping using addCount
     * @return Address of theater
     */
    public String getTheaterAddress(){
        return theater.get(addCount++).getTheateraddress();
    }
    
    /**
     * Returns list of theaters for a given zip
     * @return List of theaters
     */
    public List<Theaters> getTheaterList(){
        if(!zip.equals(""))
            return theaterEJB.getTheater(zip);
        else
            return null;
    }
    
    /**
     * Resets global variables nameCount and addCount to 0 for iterating over theaters list
     */
    public void reset(){
        nameCount = 0;
        addCount = 0;
    }
}
