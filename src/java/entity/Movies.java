/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Will
 */
@Entity
@Table(name = "MOVIES")
@NamedQueries({
    @NamedQuery(name = "Movies.findAll", query = "SELECT m FROM Movies m"),
    @NamedQuery(name = "Movies.findByTheatername", query = "SELECT m FROM Movies m WHERE m.moviesPK.theatername = :theatername"),
    @NamedQuery(name = "Movies.findByMoviename", query = "SELECT m FROM Movies m WHERE m.moviesPK.moviename = :moviename"),
    @NamedQuery(name = "Movies.findByDescription", query = "SELECT m FROM Movies m WHERE m.description = :description")})
public class Movies implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MoviesPK moviesPK;
    @Size(max = 1000)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "THEATERNAME", referencedColumnName = "THEATERNAME", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Theaters theaters;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movies")
    private Collection<Listtimes> listtimesCollection;

    public Movies() {
    }

    public Movies(MoviesPK moviesPK) {
        this.moviesPK = moviesPK;
    }

    public Movies(String theatername, String moviename) {
        this.moviesPK = new MoviesPK(theatername, moviename);
    }

    public MoviesPK getMoviesPK() {
        return moviesPK;
    }

    public void setMoviesPK(MoviesPK moviesPK) {
        this.moviesPK = moviesPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Theaters getTheaters() {
        return theaters;
    }

    public void setTheaters(Theaters theaters) {
        this.theaters = theaters;
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
        hash += (moviesPK != null ? moviesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movies)) {
            return false;
        }
        Movies other = (Movies) object;
        if ((this.moviesPK == null && other.moviesPK != null) || (this.moviesPK != null && !this.moviesPK.equals(other.moviesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Movies[ moviesPK=" + moviesPK + " ]";
    }
    
}
