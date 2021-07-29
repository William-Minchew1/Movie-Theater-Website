/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Movies;
import entity.Theaters;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Will
 */
@Stateless
public class TheaterEJB {

    @PersistenceContext(unitName = "Project1PU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Theaters> getTheater (String zip){
        return em.createNamedQuery("Theaters.findByZip", Theaters.class)
                .setParameter("zip", Integer.valueOf(zip))
                .getResultList();
    }
    
    public List<Movies> getMovies(Theaters theaterName){
        return em.createNamedQuery("Movies.findByTheaterName", Movies.class)
                .setParameter("theatername", theaterName)
                .getResultList();
    }
    

}
