/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.TheaterEJB;
import entity.Movies;
import entity.Theaters;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Will
 */
@Named(value = "moviesBean")
@RequestScoped
public class MoviesBean {

    @EJB
    private TheaterEJB theaterEJB;
    private List<Movies> movies;

    /**
     * Creates a new instance of MoviesBean
     */
    public MoviesBean() {
    }

    public List<Movies> getMovies() {
        return movies;
    }

    public String getMovieName() {
        return movies.get(0).getMoviename();
    }
//    public List<Movies> getMovieList() {
//        if (!zip.equals("")) {
//            return theaterEJB.getMovie(theaterName);
//        } else {
//            return null;
//        }
//    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }

    public String showMovies(Theaters theater) {
        this.movies = theaterEJB.getMovies(theater);
        return "ShowMovies.xhtml?faces-redirect=true";
    }
}
