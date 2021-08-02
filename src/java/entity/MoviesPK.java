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
public class MoviesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "THEATERNAME")
    private String theatername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MOVIENAME")
    private String moviename;

    public MoviesPK() {
    }

    public MoviesPK(String theatername, String moviename) {
        this.theatername = theatername;
        this.moviename = moviename;
    }

    public String getTheatername() {
        return theatername;
    }

    public void setTheatername(String theatername) {
        this.theatername = theatername;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (theatername != null ? theatername.hashCode() : 0);
        hash += (moviename != null ? moviename.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MoviesPK)) {
            return false;
        }
        MoviesPK other = (MoviesPK) object;
        if ((this.theatername == null && other.theatername != null) || (this.theatername != null && !this.theatername.equals(other.theatername))) {
            return false;
        }
        if ((this.moviename == null && other.moviename != null) || (this.moviename != null && !this.moviename.equals(other.moviename))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MoviesPK[ theatername=" + theatername + ", moviename=" + moviename + " ]";
    }
    
}
