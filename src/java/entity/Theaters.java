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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Will
 */
@Entity
@Table(name = "THEATERS")
@NamedQueries({
    @NamedQuery(name = "Theaters.findAll", query = "SELECT t FROM Theaters t"),
    @NamedQuery(name = "Theaters.findByZip", query = "SELECT t FROM Theaters t WHERE t.zip = :zip"),
    @NamedQuery(name = "Theaters.findByTheatername", query = "SELECT t FROM Theaters t WHERE t.theatername = :theatername"),
    @NamedQuery(name = "Theaters.findByTheateraddress", query = "SELECT t FROM Theaters t WHERE t.theateraddress = :theateraddress")})
public class Theaters implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZIP")
    private int zip;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "THEATERNAME")
    private String theatername;
    @Size(max = 50)
    @Column(name = "THEATERADDRESS")
    private String theateraddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theaters")
    private Collection<Movies> moviesCollection;

    public Theaters() {
    }

    public Theaters(String theatername) {
        this.theatername = theatername;
    }

    public Theaters(String theatername, int zip) {
        this.theatername = theatername;
        this.zip = zip;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getTheatername() {
        return theatername;
    }

    public void setTheatername(String theatername) {
        this.theatername = theatername;
    }

    public String getTheateraddress() {
        return theateraddress;
    }

    public void setTheateraddress(String theateraddress) {
        this.theateraddress = theateraddress;
    }

    public Collection<Movies> getMoviesCollection() {
        return moviesCollection;
    }

    public void setMoviesCollection(Collection<Movies> moviesCollection) {
        this.moviesCollection = moviesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (theatername != null ? theatername.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Theaters)) {
            return false;
        }
        Theaters other = (Theaters) object;
        if ((this.theatername == null && other.theatername != null) || (this.theatername != null && !this.theatername.equals(other.theatername))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Theaters[ theatername=" + theatername + " ]";
    }
    
}
