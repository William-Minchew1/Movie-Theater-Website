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
@Table(name = "AUTHORS")
@NamedQueries({
    @NamedQuery(name = "Authors.findAll", query = "SELECT a FROM Authors a"),
    @NamedQuery(name = "Authors.findByAuthorid", query = "SELECT a FROM Authors a WHERE a.authorid = :authorid"),
    @NamedQuery(name = "Authors.findByAuthorname", query = "SELECT a FROM Authors a WHERE a.authorname = :authorname"),
    @NamedQuery(name = "Authors.findByAuthor", query = "SELECT b FROM Authors a, Books b, Bookauthors c WHERE b.isbn = c.bookauthorsPK.isbn and c.bookauthorsPK.authorid = a.authorid and a.authorid = :authorid")})
public class Authors implements Serializable {

    @Size(max = 50)
    @Column(name = "AUTHORNAME")
    private String authorname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authors")
    private Collection<Bookauthors> bookauthorsCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(max = 2)
    @Column(name = "AUTHORID")
    private String authorid;
    @ManyToMany(mappedBy = "authorsCollection")
    private Collection<Books> booksCollection;

    public Authors() {
    }

    public Authors(String authorid) {
        this.authorid = authorid;
    }

    public String getAuthorid() {
        return authorid;
    }

    public void setAuthorid(String authorid) {
        this.authorid = authorid;
    }


    public Collection<Books> getBooksCollection() {
        return booksCollection;
    }

    public void setBooksCollection(Collection<Books> booksCollection) {
        this.booksCollection = booksCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authorid != null ? authorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Authors)) {
            return false;
        }
        Authors other = (Authors) object;
        if ((this.authorid == null && other.authorid != null) || (this.authorid != null && !this.authorid.equals(other.authorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Authors[ authorid=" + authorid + " ]";
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    @XmlTransient
    public Collection<Bookauthors> getBookauthorsCollection() {
        return bookauthorsCollection;
    }

    public void setBookauthorsCollection(Collection<Bookauthors> bookauthorsCollection) {
        this.bookauthorsCollection = bookauthorsCollection;
    }
    
}
