/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Will
 */
@Stateless
public class SurveyEJB {

    @PersistenceContext(unitName = "RestaurantHWJSFPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

}
