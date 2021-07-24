/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Will
 */
@Embeddable
public class BookauthorsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "ISBN")
    private String isbn;
    @Basic(optional = false)
    @NotNull
    @Size(max = 2)
    @Column(name = "AUTHORID")
    private String authorid;

    public BookauthorsPK() {
    }

    public BookauthorsPK(String isbn, String authorid) {
        this.isbn = isbn;
        this.authorid = authorid;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthorid() {
        return authorid;
    }

    public void setAuthorid(String authorid) {
        this.authorid = authorid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        hash += (authorid != null ? authorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookauthorsPK)) {
            return false;
        }
        BookauthorsPK other = (BookauthorsPK) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        if (this.authorid != other.authorid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BookauthorsPK[ isbn=" + isbn + ", authorid=" + authorid + " ]";
    }
    
}
