/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.Booksjdbc;
import entity.Authors;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Will
 */
@Named(value = "mainPageBean")
@RequestScoped
public class MainPageBean {

    @EJB
    private Booksjdbc booksjdbc;

    /**
     * Creates a new instance of MainPageBean
     */
    public MainPageBean() {
    }
    
    public List<Authors> getAuthorList()
    {
        return booksjdbc.findAllAuthors();
    }
}
