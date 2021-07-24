/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Will
 */
@Entity
@Table(name = "BOOKAUTHORS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookauthors.findAll", query = "SELECT b FROM Bookauthors b"),
    @NamedQuery(name = "Bookauthors.findByIsbn", query = "SELECT b FROM Bookauthors b WHERE b.bookauthorsPK.isbn = :isbn"),
    @NamedQuery(name = "Bookauthors.findByAuthorid", query = "SELECT b FROM Bookauthors b WHERE b.bookauthorsPK.authorid = :authorid"),
    @NamedQuery(name = "Bookauthors.findByPlaceholder", query = "SELECT b FROM Bookauthors b WHERE b.placeholder = :placeholder")})
public class Bookauthors implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BookauthorsPK bookauthorsPK;
    @Column(name = "PLACEHOLDER")
    private Boolean placeholder;
    @JoinColumn(name = "AUTHORID", referencedColumnName = "AUTHORID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Authors authors;
    @JoinColumn(name = "ISBN", referencedColumnName = "ISBN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Books books;

    public Bookauthors() {
    }

    public Bookauthors(BookauthorsPK bookauthorsPK) {
        this.bookauthorsPK = bookauthorsPK;
    }

    public Bookauthors(String isbn, String authorid) {
        this.bookauthorsPK = new BookauthorsPK(isbn, authorid);
    }

    public BookauthorsPK getBookauthorsPK() {
        return bookauthorsPK;
    }

    public void setBookauthorsPK(BookauthorsPK bookauthorsPK) {
        this.bookauthorsPK = bookauthorsPK;
    }

    public Boolean getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(Boolean placeholder) {
        this.placeholder = placeholder;
    }

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookauthorsPK != null ? bookauthorsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookauthors)) {
            return false;
        }
        Bookauthors other = (Bookauthors) object;
        if ((this.bookauthorsPK == null && other.bookauthorsPK != null) || (this.bookauthorsPK != null && !this.bookauthorsPK.equals(other.bookauthorsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bookauthors[ bookauthorsPK=" + bookauthorsPK + " ]";
    }
    
}
