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
import javax.persistence.ManyToOne;
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
@Table(name = "MOVIES")
@NamedQueries({
    @NamedQuery(name = "Movies.findAll", query = "SELECT m FROM Movies m"),
    @NamedQuery(name = "Movies.findByMoviename", query = "SELECT m FROM Movies m WHERE m.moviename = :moviename"),
    @NamedQuery(name = "Movies.findByDescription", query = "SELECT m FROM Movies m WHERE m.description = :description"),
    @NamedQuery(name = "Movies.findByTheaterName", query = "SELECT m FROM Movies m WHERE m.theatername = :theatername")})
public class Movies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MOVIENAME")
    private String moviename;
    @Size(max = 1000)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "THEATERNAME", referencedColumnName = "THEATERNAME")
    @ManyToOne
    private Theaters theatername;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movies")
    private Collection<Listtimes> listtimesCollection;

    public Movies() {
    }

    public Movies(String moviename) {
        this.moviename = moviename;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Theaters getTheatername() {
        return theatername;
    }

    public void setTheatername(Theaters theatername) {
        this.theatername = theatername;
    }

    public Collection<Listtimes> getListtimesCollection() {
        return listtimesCollection;
    }

    public void setListtimesCollection(Collection<Listtimes> listtimesCollection) {
        this.listtimesCollection = listtimesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moviename != null ? moviename.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movies)) {
            return false;
        }
        Movies other = (Movies) object;
        if ((this.moviename == null && other.moviename != null) || (this.moviename != null && !this.moviename.equals(other.moviename))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Movies[ moviename=" + moviename + " ]";
    }
    
}
