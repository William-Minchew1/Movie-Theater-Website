/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Will
 */
@Entity
@Table(name = "LISTTIMES")
@NamedQueries({
    @NamedQuery(name = "Listtimes.findAll", query = "SELECT l FROM Listtimes l"),
    @NamedQuery(name = "Listtimes.findByMoviename", query = "SELECT l FROM Listtimes l WHERE l.listtimesPK.moviename = :moviename"),
    @NamedQuery(name = "Listtimes.findByListtime", query = "SELECT l FROM Listtimes l WHERE l.listtimesPK.listtime = :listtime"),
    @NamedQuery(name = "Listtimes.findByTheatername", query = "SELECT l FROM Listtimes l WHERE l.listtimesPK.theatername = :theatername")})
public class Listtimes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ListtimesPK listtimesPK;
    @JoinColumns({
        @JoinColumn(name = "MOVIENAME", referencedColumnName = "MOVIENAME", insertable = false, updatable = false),
        @JoinColumn(name = "THEATERNAME", referencedColumnName = "THEATERNAME", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Movies movies;

    public Listtimes() {
    }

    public Listtimes(ListtimesPK listtimesPK) {
        this.listtimesPK = listtimesPK;
    }

    public Listtimes(String moviename, String listtime, String theatername) {
        this.listtimesPK = new ListtimesPK(moviename, listtime, theatername);
    }

    public ListtimesPK getListtimesPK() {
        return listtimesPK;
    }

    public void setListtimesPK(ListtimesPK listtimesPK) {
        this.listtimesPK = listtimesPK;
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (listtimesPK != null ? listtimesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listtimes)) {
            return false;
        }
        Listtimes other = (Listtimes) object;
        if ((this.listtimesPK == null && other.listtimesPK != null) || (this.listtimesPK != null && !this.listtimesPK.equals(other.listtimesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Listtimes[ listtimesPK=" + listtimesPK + " ]";
    }
    
}
