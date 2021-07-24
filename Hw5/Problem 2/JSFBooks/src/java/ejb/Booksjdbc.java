/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Authors;
import entity.Books;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Will
 */
@Stateless
public class Booksjdbc {

    @PersistenceContext(unitName = "JSFBooksPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Authors> findAllAuthors()
    {
        return em.createNamedQuery("Authors.findAll", Authors.class).getResultList(); 
    }
    
    public Authors getAuthor(String id)
    {
        return em.createNamedQuery("Authors.findByAuthorid", Authors.class)
                .setParameter("authorid", id)
                .getSingleResult();
    }
    
    public List<Books> getBooksforAuthor(String id)
    {
        return em.createNamedQuery("Authors.findByAuthor", Books.class)
                .setParameter("authorid", id)
                .getResultList();
    }
}
