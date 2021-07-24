/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.Booksjdbc;
import entity.Authors;
import entity.Books;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Will
 */
@Named(value = "showBooksBean")
@RequestScoped
public class ShowBooksBean {

    @EJB
    private Booksjdbc booksjdbc;
    private Authors author;
    /**
     * Creates a new instance of ShowBooksBean
     */
    public ShowBooksBean() {
    }

    public Authors getAuthor() {
        return author;
    }

    public void setAuthor(Authors author) {
        this.author = author;
    }
    
    public String showAuthor(Authors author) {
        this.author = author;
        return "ShowAuthor.xhtml";
    }
    
    public String backToAuthor() {
      FacesContext fc = FacesContext.getCurrentInstance();
      Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
      String id = params.get("authorid"); 
      author = booksjdbc.getAuthor(id);
      return "ShowAuthor.xhtml";
    }
    
    public String showWrittenBooks() {
      FacesContext fc = FacesContext.getCurrentInstance();
      Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
      String id =  params.get("authorid"); 
      author = booksjdbc.getAuthor(id);
      return "ShowBooks.xhtml";
    }
    
    public List<Books> getBookList()
    {
        if (author != null)
           return booksjdbc.getBooksforAuthor(author.getAuthorid());
        else
           return null;
    }
}
