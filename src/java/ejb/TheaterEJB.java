/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Theaters;
import java.util.List;
import javax.ejb.Stateless;
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

    /**
     * Returns a list of Theaters objects using zip and a namedquery to search the database
     * @param zip String used to search
     * @return List of theaters
     */
    public List<Theaters> getTheater(String zip) {
        return em.createNamedQuery("Theaters.findByZip", Theaters.class)
                .setParameter("zip", Integer.valueOf(zip))
                .getResultList();
    }
    
    /**
     * Returns a list of all theaters in the database
     * @return List of all theaters
     */
    public List<Theaters> getAllTheaters(){
        return em.createNamedQuery("Theaters.findAll", Theaters.class)
                .getResultList();
    }
}
