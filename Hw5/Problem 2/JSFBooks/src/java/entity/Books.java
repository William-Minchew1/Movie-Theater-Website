/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Will
 */
@Entity
@Table(name = "BOOKS")
@NamedQueries({
    @NamedQuery(name = "Books.findAll", query = "SELECT b FROM Books b"),
    @NamedQuery(name = "Books.findByIsbn", query = "SELECT b FROM Books b WHERE b.isbn = :isbn"),
    @NamedQuery(name = "Books.findByTitle", query = "SELECT b FROM Books b WHERE b.title = :title"),
    @NamedQuery(name = "Books.findByPages", query = "SELECT b FROM Books b WHERE b.pages = :pages")})
public class Books implements Serializable {

    @Size(max = 50)
    @Column(name = "TITLE")
    private String title;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "books")
    private Collection<Bookauthors> bookauthorsCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "ISBN")
    private String isbn;
    @Column(name = "PAGES")
    private Integer pages;
    @JoinTable(name = "BOOKAUTHORS", joinColumns = {
        @JoinColumn(name = "ISBN", referencedColumnName = "ISBN")}, inverseJoinColumns = {
        @JoinColumn(name = "AUTHORID", referencedColumnName = "AUTHORID")})
    @ManyToMany
    private Collection<Authors> authorsCollection;

    public Books() {
    }

    public Books(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Collection<Authors> getAuthorsCollection() {
        return authorsCollection;
    }

    public void setAuthorsCollection(Collection<Authors> authorsCollection) {
        this.authorsCollection = authorsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Books[ isbn=" + isbn + " ]";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlTransient
    public Collection<Bookauthors> getBookauthorsCollection() {
        return bookauthorsCollection;
    }

    public void setBookauthorsCollection(Collection<Bookauthors> bookauthorsCollection) {
        this.bookauthorsCollection = bookauthorsCollection;
    }
    
}
