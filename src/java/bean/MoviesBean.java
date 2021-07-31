/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.TheaterEJB;
import entity.Listtimes;
import entity.Movies;
import entity.Theaters;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Will
 */
@Named(value = "moviesBean")
@SessionScoped
public class MoviesBean implements Serializable{

    @EJB
    private TheaterEJB theaterEJB;
    private Collection<Movies> movies;
    private Movies movie;
    private Theaters theater;

    /**
     * Creates a new instance of MoviesBean
     */
    public MoviesBean() {
    }

    public Collection<Movies> getMovies() {
        return movies;
    }
    
    public Movies getCurrentMovie(){
        return movie;
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }

    public String showMovies(Theaters theater) {
        this.theater = theater;
        return "ShowMovies.xhtml?faces-redirect=true";
    }
    
    public String getMovieName(){
        return movie.getMoviename();
    }
    
    public Collection<Movies> getMovieList(){
            return theater.getMoviesCollection();
    }
    
    public String showListTimes(Movies movie){
        this.movie = movie;
        return "ShowListTimes.xhtml?faces-redirect=true";
    }
    
    public Collection<Listtimes> getListTimesList(){
            return movie.getListtimesCollection();
    }
    
}
